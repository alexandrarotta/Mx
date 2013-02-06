(ns mx.core
  (:use [clojure.pprint :only [cl-format]]))

(declare send-to apply-message-to)

;;; Functions that construct the different kinds of objects

(def basic-object
     (fn [method-holder-symbol]
       {:__left_symbol__ method-holder-symbol}))

(def method-holder
     (fn [my-name
          _left left-symbol
          _up up-symbol
          methods]
       (assert (= _left :left))
       (assert (= _up :up))
       (assoc (basic-object left-symbol)
              :__own_symbol__ my-name
              :__up_symbol__ up-symbol
              :__methods__ methods)))

(def install 
     (fn [method-holder]
         (intern *ns* (:__own_symbol__ method-holder) method-holder)
         method-holder))

(def metasymbol
     (fn [some-symbol]
       (symbol (str "Meta" some-symbol))))

(def invisible
     (fn [method-holder]
       (assoc method-holder :__invisible__ true)))

(def invisible?
     (fn [method-holder-symbol] (:__invisible__ (eval method-holder-symbol))))


;;; Here are methods that take a method-holder-symbol or instance containing one and follow it somewhere. 

(def method-holder-symbol-above
     (fn [method-holder-symbol]
       (assert (symbol? method-holder-symbol))
       (:__up_symbol__ (eval method-holder-symbol))))

(def held-methods
     (fn [method-holder-symbol]
       (assert (symbol? method-holder-symbol))
       (:__methods__ (eval method-holder-symbol))))

(def left-from-instance
     (fn [instance]
       (assert (map? instance))
       (eval (:__left_symbol__ instance))))

(def left-up-from-instance
     (fn [instance]
       (assert (map? instance))
       (eval (:__up_symbol__ (left-from-instance instance)))))


;; Core dispatch function

(def lineage-1
     (fn [method-holder-symbol so-far]
       (if (nil? method-holder-symbol)
         so-far
         (lineage-1 (method-holder-symbol-above method-holder-symbol)
                    (cons method-holder-symbol so-far)))))
(def lineage
     (fn [method-holder-symbol]
       (lineage-1 method-holder-symbol [])))

(def method-cache
     (fn [method-holder]
       (let [method-holder-symbol (:__own_symbol__ method-holder)
             method-maps (map held-methods
                              (lineage method-holder-symbol))]
         (apply merge method-maps))))

(def apply-message-to
     (fn [method-holder instance message args]
       (let [method (message (method-cache method-holder))]
         (if method
           (apply method instance args)
           (send-to instance :method-missing message args)))))



;;; The public interface

(def send-to
     (fn [instance message & args]
       (apply-message-to (left-from-instance instance)
                         instance message args)))

;;; The two class/pairs from which everything else can be built

;; Anything
(install (method-holder 'Anything,
                      :left 'MetaAnything,
                      :up nil,
                      {
                       :add-instance-values identity
                       :method-missing
                       (fn [this message args]
                         (throw (Error. (cl-format nil "A ~A does not accept the message ~A."
                                                   (send-to this :class-name)
                                                   message))))
                       :to-string (fn [this] (str this))

                       :class
                       (fn [this]
                         (eval (send-to this :class-name)))

                       :class-name 
                       (fn [this]
                         (first (send-to (left-from-instance this) :ancestors)))
                       }))
                            
(install
 (invisible
  (method-holder 'MetaAnything,
               :left 'Klass,
               :up 'Klass,
               { 
               })))


;; Klass
(install (method-holder 'Klass,
                        :left 'MetaKlass,
                        :up 'Module,             ;; <<== new
                        {
                         :new
                         (fn [class & args]
                           (let [seeded {:__left_symbol__ (:__own_symbol__ class)}]
                             (apply-message-to class seeded :add-instance-values args)))

                         :to-string
                         (fn [class]
                           (str "class " (:__own_symbol__ class)))

                         :ancestors
                         (fn [class]
                           (remove invisible?
                                   (reverse (lineage (:__own_symbol__ class)))))
                         }))
                            
(install
 (invisible
  (method-holder 'MetaKlass,
                 :left 'Klass,
                 :up 'MetaModule,              ;; <<== new
                 {
                  :new
                  (fn [this
                       new-class-symbol superclass-symbol
                       instance-methods class-methods]
                    ;; Metaclass
                    (install
                     (invisible
                      (method-holder (metasymbol new-class-symbol)
                                     :left 'Klass
                                     :up 'MetaAnything
                                     class-methods)))
                    ;; Class
                    (install
                     (method-holder new-class-symbol
                                    :left (metasymbol new-class-symbol)
                                    :up superclass-symbol
                                    instance-methods)))
                  })))


(install
 (invisible
  (method-holder 'MetaModule
               :left 'Klass
               :up 'Klass
               {
                :new
                (fn [this name methods]
                  (install
                   (method-holder name
                                  ;; We move left to find `:install`.
                                  ;; That means the class `Module` must be in
                                  ;; the "up" chain of the leftward object.
                                  ;; Since we don't have a need for a Meta
                                  ;; version of this new module, "left" can
                                  ;; point directly at `Module`. 
                                  :left 'Module

                                  ;; If `:up` pointed to, say, `Anything`, then
                                  ;; the methods from `Anything` would get
                                  ;; inserted into the inheritance chain earlier than
                                  ;; they would otherwise be, preventing other classes
                                  ;; from overriding them.
                                  :up nil
                                  
                                  methods)))
                })))

(install
 (method-holder 'Module
                :left 'MetaModule
                :up 'Anything
                {
                 :include
                 (fn [this module]
                   (let [module-name (:__own_symbol__ module)
                         stub-name (gensym module-name)
                         stub {:__own_symbol__ stub-name
                               :__up_symbol__ (:__up_symbol__ this)
                               :__left_symbol__ module-name
                               :__module_stub?__ true}]              ;;<<== New
                     (install (assoc this :__up_symbol__ stub-name))
                     (install stub)))
               }))

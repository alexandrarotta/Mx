(ns mx.theory
  (:use [mx.core])
  (:use [mx.notes])
  (:use [mx.durations])
  (:use [mx.intervals])
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic.protocols]
        [clojure.core.logic :exclude [is] :as l])
  (:require [clojure.core.logic.fd :as fd]))

(send-to Klass :new
         'Counterpoint 'Anything
         {
          :add-instance-values
          (fn [this cantus-firmus]
            (assoc this :cantus-firmus cantus-firmus))

          :cantus-firmus :cantus-firmus   
          
          :create-mayor-melody
          (fn [this low-note high-note length tonica]                      
            (let [vars (repeatedly length lvar)]              
              (run-nc 1 [q]
                      (== q vars)
                      (distribute q ::l/ff)
          (println "here")         
                      (let [idx 0]
                        (doseq [var vars]
                          
                          
                          (cond 
                            (= idx 0) (fd/in var (fd/domain tonica))
                            (> idx 0) (fd/in var (fd/domain c4 d4 e4 f4 g4 a4 b4 c5))
                            (= idx length) (fd/in var (fd/domain c4 g4 c5)))
                          (def idx (+ idx 1)))))))

          
          :create-first-species-counterpoint
          (fn [this low-note high-note]
            
            
            
            (def index 0)
                                
            (doseq [phrase  (:items (:cantus-firmus this))]
              
              (print phrase)
              
              (if (compare (:__left_symbol__ phrase) 'Motive)
                (let [n (count (:items (:items phrase)))
                      vars (repeatedly n lvar)]
                (doseq [voice (:items phrase)]
                  (doseq [note (:items voice)]
                      
                      (run-nc 1 [q]
                              (== q vars)
                             (distribute q ::l/ff)
                              (everyg #(fd/in % (fd/domain 1 2 3 4 5 6 7 8 9)) vars)
                              (everyg fd/distinct vars)))
          
                    (def index (+ index 1)))))
                  
              (if (compare (:__left_symbol__ phrase) 'Cadense)
                (let [ n (count (:items (:items phrase)))
                      vars (repeatedly n lvar)]

                (doseq [voice (:items phrase)]
                  (doseq [note (:items voice)]

                      (run-nc 1 [q]
                              (== q vars)
                              (distribute q ::l/ff)
                              (everyg #(fd/in % (fd/domain 1 2 3 4 5 6 7 8 9)) vars)
                              (everyg fd/distinct vars)))
 
                  (def index (+ index 1)))))))
          
            
            ;(print low-note high-note)
                         
         } {})


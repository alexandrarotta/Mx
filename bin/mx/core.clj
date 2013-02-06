(ns mx.core
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic])
  (:require [clojure.core.logic.fd])
  (:require [clojure.pprint]))


(def make
  ^{:doc "make an instance off [class] whit the [args] on the constructor"}
(fn [class & args]
  (let [seeded {:__class_symbol__ (:__own_symbol__ class)}
        constructor  (:add-instance-values (:__instance_methods__ class))]
    (apply constructor seeded args))))

(def send-to
  ^{:doc "send [message] to [instance] with [args] as arguments"}
(fn [instance message & args]
  (let [class (eval (:__class_symbol__ instance))
        method (message (:__instance_methods__ class))]
    (apply method instance args))))

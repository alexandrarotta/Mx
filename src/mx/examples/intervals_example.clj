(ns mx.examples.intervals-example
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic :exclude [is] :as l]
        [clojure.core.logic.nominal :exclude [fresh hash] :as nom])
  (:require [clojure.pprint :as pp]
            [clojure.core.logic.fd :as fd])
  (:use [mx.power-midi]
        [mx.core]
        [mx.notes]
        [mx.intervals]
        [mx.durations]))

(def giben-notes (list e4 a4 d4 g4 b4 f+4 c4 g+4 f4 c+4 d+4 b-4))
(def giben-intervals (list _d8 _m2 _d3 _P4 _A5 _m6 _d7))

(defn notes-on-intervalic-structure
  ^{:doc "Create a secuence of notes with the [start-note] and the [intervalic-structure]."}
  [start-note intervalic-structure]
  (if-not (empty? intervalic-structure)
    (concat start-note (notes-on-intervalic-structure (list (+ (first start-note) (first intervalic-structure))) (rest intervalic-structure)))))



(def midi (make Midi nil))
(send-to midi :create-copyright-event "Copyright © Oscar Riveros, 2013, Todos los derechos reservados." 0)
(def music (send-to midi :create-secuence 1))
(def track (send-to midi :create-track music))
(doseq [gn giben-notes]
  (loop [notes (notes-on-intervalic-structure (list gn) giben-intervals)]
    (def index 0)
    (doseq [note notes]
      (send-to midi :create-note track 1 note 64 (* index 1/2) 1/2)
      (def index (inc index)))))

(send-to midi :create-midi-file music "/Google Drive/tmp/intervals-example.mid")


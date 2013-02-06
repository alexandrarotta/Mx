(ns mx.examples.all-scales
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic :exclude [is] :as l]
        [clojure.core.logic.nominal :exclude [fresh hash] :as nom])
  (:require [clojure.pprint :as pp]
            [clojure.core.logic.fd :as fd])
  (:use [mx.midi]
        [mx.core]
        [mx.durations]
        [mx.intervals]))
  
(defn notes-on-intervalic-structure
  ^{:doc "Create a secuence of notes with the [start-note] and the [intervalic-structure]."}
  [start-note intervalic-structure]
  (if-not (empty? intervalic-structure)
    (concat start-note (notes-on-intervalic-structure (list (+ (first start-note) (first intervalic-structure))) (rest intervalic-structure)))))

(defn make-all-scales-from-interval-structure
  ^{:doc "Create a secuence of notes from the [low-note] to [high-note] and the [intervalic-structure]."}
  [low-note high-note intervalic-structure]
  (let [base-note-list
        (run* [q]
              (fresh [base-note]
                     (fd/in base-note (fd/interval low-note high-note))
                     (== q base-note)))]
    (map #(notes-on-intervalic-structure (list %) intervalic-structure) base-note-list)))

;Sorted mayor scales
;(make-all-scales-from-interval-structure 60 72 '(2 2 1 2 2 2 1))

(def midi (make Midi nil nil))
(send-to midi :create-copyright-event "Copyright © Oscar Riveros, 2013, Todos los derechos reservados." 0)
(def music (send-to midi :create-secuence 1))
(def track (send-to midi :create-track music))
(loop [scales (make-all-scales-from-interval-structure 60 72 (list _P5 (- _M2) (- _m3) _P5 (- _P4) _P5 _m2))]
  (def index 0)
  (doseq [notes scales]
    (doseq [note notes]
      (send-to midi :create-note track 1 note 64 (* index semibreve) semibreve) 
      (def index (inc index)))))

(send-to midi :create-midi-file music "/Google Drive/tmp/all-mayor-scales.mid")

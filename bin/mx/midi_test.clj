(ns mx.midi-test
  (:use clojure.test
        mx.core
        mx.midi))

(def midi (make Midi))
(send-to midi :)

(defn make-chromatic-scale
  [low-note high-note]
  (let [vars (repeatedly 3 lvar)]
    (run* [q]
          (== q vars)
          (everyg #(infd % (interval low-note high-note)) vars)                 
          (=fd low-note vars)
          (=fd vars high-note)
          )))

(make-chromatic-scale 60 72)

(def notes (make-chromatic-scale 60 72))
(def music (create-sequence Sequence/PPQ 64 1))
(def track (create-track music))
(def index 0)
(doseq [note notes]
    (create-note track note 64 (* index 1/4) 1/4 0)
    (def index (inc index)))
  (create-midi-file music "/Users/maxtuno/Downloads/Chromatic-Scales.mid")
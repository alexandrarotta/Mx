(ns mx.matter
  (:use [mx.core])
  (:use [mx.notes])
  (:use [mx.durations])
  (:use [mx.intervals])
  (:use [mx.midi]))

(send-to Klass :new
         'Matter 'Anything
         {
          :add-instance-values
          (fn [this scores]
            (assoc this :scores scores))

          :scores :scores
          
          :materialize
          (fn [this]
            (def midi (send-to Midi :new 0.0 64))
            (send-to midi :create-copyright-event "Copyright © Oscar Riveros, 2013, Todos los derechos reservados." 0)
            (def music (send-to midi :create-sequence))
            (def track (send-to midi :create-track music))
            
            (doseq [score (:scores this)]
              (doseq [container (:containers score)]
                (doseq [item (:items container)]
                  (def index 0)
                  (doseq [note (:notes item)]
                    (println (:pitch note) (:amplitude note) (:duration note))
                    (send-to midi :create-note track 1 (:pitch note) (:amplitude note) (* index (:duration note)) (:duration note))                     
                    (def index (inc index))))))
            (send-to midi :create-midi-file music "/Google Drive/tmp/mx.mid"))
          } {})


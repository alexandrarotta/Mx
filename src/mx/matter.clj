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
          (fn [this score]
            (assoc this :score score))

          :score :score
          
          :materialize
          (fn [this]
            (def midi (send-to Midi :new 0.0 64))
            (send-to midi :create-copyright-event "Copyright © Oscar Riveros, 2013, Todos los derechos reservados." 0)
            (def music (send-to midi :create-sequence))
            (def track (send-to midi :create-track music))
            
                                                                   
            (def idx-matter 0)
                  
            (doseq [structure (:items (:score this))]                 
              (doseq [form (:items structure)]               
                (doseq [phrase (:items form)]
                                          
                  (if (compare (:__left_symbol__ phrase) 'Motive)
                    (doseq [voice (:items phrase)]
                      (doseq [note (:items voice)]
                        (send-to midi :create-note track (:number voice) (:pitch note) (:amplitude note) (* (:duration note) idx-matter) (:duration note))
                        (def idx-matter (+ idx-matter 1)))))
                  
                  (if (compare (:__left_symbol__ phrase) 'Cadense)
                    (doseq [voice (:items phrase)]
                      (doseq [note (:items voice)]
                        (send-to midi :create-note track (:number voice) (:pitch note) (:amplitude note) (* (:duration note) idx-matter) (:duration note))
                        (def idx-matter (+ idx-matter 1))))))))
                                                        
                (send-to midi :create-midi-file music "/Google Drive/tmp/mx.mid"))
          
          } {})


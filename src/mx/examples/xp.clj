(ns mx.examples.xp
  (:use
    [mx.core]
    [mx.notes]
    [mx.durations]
    [mx.intervals]
    [mx.music]
    [mx.matter]
    [mx.midi]
    [mx.theory]))



(def note-1    (send-to Note      :new 62 s_ 64))
(def note-2    (send-to Note      :new 65 s_ 64))
(def note-3    (send-to Note      :new 64 s_ 64))
(def note-4    (send-to Note      :new 62 s_ 64))
(def note-5    (send-to Note      :new 67 s_ 64))
(def note-6    (send-to Note      :new 65 s_ 64))
(def note-7    (send-to Note      :new 69 s_ 64))
(def note-8    (send-to Note      :new 67 s_ 64))
(def note-9    (send-to Note      :new 65 s_ 64))
(def note-10   (send-to Note      :new 64 s_ 64))
(def note-11   (send-to Note      :new 62 s_ 64))

(def voice-1f  (send-to Voice     :new (list note-1 note-2 note-3 note-4 note-5 note-6 note-7 note-8) 1))
(def voice-1c  (send-to Voice     :new (list note-9 note-10 note-11) 1))

(def motive-1  (send-to Motive    :new (list voice-1f)))
(def cadence-1 (send-to Cadence   :new (list voice-1c)))
(def form-1    (send-to Form      :new (list motive-1 cadence-1)))
(def structure (send-to Structure :new (list form-1)))
(def score     (send-to Score     :new (list structure)))

(def matter    (send-to Matter    :new score))
(send-to matter :materialize)

;(def counterpoint (send-to Counterpoint :new form-1))
;(send-to counterpoint :create-first-species-counterpoint 1 10)
;(send-to counterpoint :create-mayor-melody 1 10 8 c4)

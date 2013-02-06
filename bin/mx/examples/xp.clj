(ns mx.examples.xp
  (:use
    [mx.core]
    [mx.notes]
    [mx.durations]
    [mx.intervals]
    [mx.music]
    [mx.matter]
    [mx.midi]))


(def note-1 (send-to Note :new c4 q_ 64))
(def note-2 (send-to Note :new d4 q_ 64))
(def note-3 (send-to Note :new e4 q_ 64))
(def note-4 (send-to Note :new f4 q_ 64))

(def items-1 (send-to Items :new (list note-1 note-2)))
(def items-2 (send-to Items :new (list note-3 note-4)))

(def sequential (send-to Sequential :new "Mx Seq 1" (list items-1) 0 5))
(def simultaneous (send-to Simultaneous :new "Mx Sim 2" (list items-2) 5 9))

(def score (send-to Score :new "Mx Score" (list sequential simultaneous)))

(def matter (send-to Matter :new (list score)))
(send-to matter :materialize)
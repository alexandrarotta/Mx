(ns mx.midi
    (:use [mx.core])
  (:import 	[javax.sound.midi
             MidiSystem
             Sequence
             ShortMessage
             MidiEvent
             MetaMessage]
           	[java.io
             File]))

(def Midi
  ^{:doc "Midi class"}
  {
   :__own_symbol__ 'Midi
   :__instance_methods__
   {
    :add-instance-values 
    (fn 
      [this division-type resolution]
      (assoc this :division-type (if-not (nil? division-type) division-type Sequence/PPQ))
      (assoc this :resolution (if-not (nil? resolution) resolution 64)))
    :shift 
    (fn 
      [this division-typesinc resolutionsinc]
      (make Midi (+ (:division-type this) (if-not (nil? division-typesinc) division-typesinc Sequence/PPQ)))
      (make Midi (+ (:resolution this) (if-not (nil? resolutionsinc) resolutionsinc 64))))
    :get-note-length 
    (fn
      [this length]
      (* (:resolution this) length))
    :create-secuence 
    (fn 
      [this num-tracks]
      (Sequence. Sequence/PPQ 64 num-tracks)) ;TODO Correct the instance variable
    :create-track 
    (fn 
      [this sequence]
      (.createTrack sequence))
    :create-note 
    (fn 
      [this track channel key velocity position duration ]
      (do
        (.add track (send-to this :create-note-on-event channel key velocity (send-to this :get-note-length position)))
        (.add track (send-to this :create-note-off-event channel key 0 (+ (send-to this :get-note-length position) (send-to this :get-note-length duration))))))
    :create-text-event
    (fn 
      [this text type tick]
      (let [message (new MetaMessage)
            bytes (. text getBytes)]
        (do 
          (.setMessage message type bytes (count bytes))
          (new MidiEvent message tick))))
    :create-copyright-event
    (fn 
      [this copyright tick]
      (send-to this :create-text-event copyright 0x02 tick))
    :create-track-name-event
    (fn 
      [this track-name tick]
      (send-to this :create-text-event track-name 0x03 tick))
    :create-instrument-name-event
    (fn 
      [this instrument-name tick]
      (send-to this :create-text-event instrument-name 0x04 tick))
    :create-note-event
    (fn 
      [this command channel note velocity tick]
      (let [message (new ShortMessage)]
        (do
          (.setMessage message command channel note velocity)
          (new MidiEvent message tick))))
    :create-note-on-event 
    (fn 
      [this channel note velocity tick]
      (send-to this :create-note-event ShortMessage/NOTE_ON channel note velocity tick))
    :create-note-off-event 
    (fn 
      [this channel note velocity tick]
      (send-to this :create-note-event ShortMessage/NOTE_OFF channel note velocity tick))
    :create-tempo-event
    (fn 
      [this bpm tick]
      (let [TEMPO-MESSAGE 81
            microseconds-per-minute 60000000
            mpqn (/ microseconds-per-minute bpm) ; microseconds per quarter note
            message (new MetaMessage)
            bytes (make-array (. Byte TYPE) 3)]
        (do 
          (aset bytes 0 (byte (bit-and (bit-shift-right mpqn 16) 0xFF)))
          (aset bytes 1 (byte (bit-and (bit-shift-right mpqn 8) 0xFF)))
          (aset bytes 2 (byte (bit-and (bit-shift-right mpqn 0) 0xFF)))
          (.setMessage message TEMPO-MESSAGE bytes 3)
          (new MidiEvent message tick))))
    :create-midi-file 
    (fn 
      [this sequence output-full-path]
      (MidiSystem/write sequence 1 (File. output-full-path)))
    }
})
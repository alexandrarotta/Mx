(ns mx.examples.anotated-music
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic :exclude [is] :as l]
        [clojure.core.logic.nominal :exclude [fresh hash] :as nom])
  (:require [clojure.pprint :as pp]
            [clojure.core.logic.fd :as fd])
  (:use [mx.midi]
        [mx.core]
        [mx.notes]
        [mx.durations]
        [mx.intervals]))

(def notes (list  c4 c4 c4  d4  e4 e4  d4  e4  f4  g4 c5  c5  c5  g4  g4  g4  e4  e4  e4  c4  c4  c4  g4  f4  e4  d4 c4))
(def tempos (list c_ c_ ct_ qt_ c_ ct_ qt_ ct_ qt_ m_ qt_ qt_ qt_ qt_ qt_ qt_ qt_ qt_ qt_ qt_ qt_ qt_ ct_ qt_ ct_ qt_ m_))

(def midi (make Midi nil nil))
(send-to midi :create-copyright-event "Copyright © Oscar Riveros, 2013, Todos los derechos reservados." 0)
(def music (send-to midi :create-secuence 1))
(def track (send-to midi :create-track music))
(def index 0)
(doseq [note notes]
  (send-to midi :create-note track 1 note 64 (* index (nth tempos index)) (nth tempos index))
  (def index (inc index)))
 
(send-to midi :create-midi-file music "/Google Drive/tmp/anotated-music.mid")



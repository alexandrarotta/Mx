(ns mx.music
  (:use [mx.core])
  (:use [mx.notes])
  (:use [mx.durations])
  (:use [mx.intervals]))

(send-to Klass :new
         'Note 'Anything
         {
          :add-instance-values
          (fn [this pitch duration amplitude]
            (assoc this :pitch pitch :duration duration :amplitude amplitude))

          :pitch :pitch 
          :duration :duration 
          :amplitude :amplitude
         } {})


(send-to Klass :new
         'Items 'Anything
         {
          :add-instance-values
          (fn [this notes]
            (assoc this :notes notes))

          :notes :notes
         } {})

(send-to Klass :new
         'Sequential 'Anything
         {
          :add-instance-values
          (fn [this info items start-time time-unit]
            (assoc this :info info :items items :start-time start-time :time-unit time-unit))

          :info :info 
          :items :items 
          :start-time :start-time 
          :time-unit :time-unit
         } {})

(send-to Klass :new
         'Simultaneous 'Anything
         {
          :add-instance-values
          (fn [this info items start-time time-unit]
            (assoc this :info info :items items :start-time start-time :time-unit time-unit))

          :info :info 
          :items :items 
          :start-time :start-time 
          :time-unit :time-unit
         } {})

(send-to Klass :new
         'Score 'Anything
         {
          :add-instance-values
          (fn [this info containers]
            (assoc this :info info :containers containers))

          :info :info 
          :containers :containers           
         } {})

;=========================================================================================================================================================


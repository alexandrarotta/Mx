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
         'Voice 'Anything
         {
          :add-instance-values
          (fn [this items number]
            (assoc this :items items :number number))
          
          :items :items
          :number :number
         } {})

(send-to Klass :new
         'Motive 'Anything
         {
          :add-instance-values
          (fn [this items]
            (assoc this :items items))
          
          :items :items
         } {})

(send-to Klass :new
         'Cadence 'Anything
         {
          :add-instance-values
          (fn [this items]
            (assoc this :items items))
          
          :items :items
         } {})

(send-to Klass :new
         'Form 'Anything
         {
          :add-instance-values
          (fn [this items]
            (assoc this :items items))
          
          :items :items
         } {})

(send-to Klass :new
         'Structure 'Anything
         {
          :add-instance-values
          (fn [this items]
            (assoc this :items items))
          
          :items :items
         } {})

(send-to Klass :new
         'Score 'Anything
         {
          :add-instance-values
          (fn [this items]
            (assoc this :items items))

          :items :items          
         } {})

(comment
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
)
;=========================================================================================================================================================


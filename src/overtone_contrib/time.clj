
(ns overtone-contrib.time
  (:use [overtone.core.time-utils :only [now schedule]]))

(def *APPLY-AHEAD* 250)

(defn apply-at [func ms-time & args]
  (let [delay-time (- ms-time (now))]
    (if (< delay-time 0)
      (apply func args)
      (schedule #(apply func args) delay-time))))

(defn apply-before [func ms-time & args]
  (apply apply-at func (- ms-time *APPLY-AHEAD*) args))










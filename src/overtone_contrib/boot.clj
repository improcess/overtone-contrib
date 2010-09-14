(ns overtone-contrib.boot
  (:use [overtone.core.sc :only [boot connected?]]))

(defn wait-till-connected
  "Sleep the executing thread until the SuperCollider server has completed its boot process (i.e. when (connected?) is true)"
  []
  (while (not (connected?)) (java.lang.Thread/sleep 50)))

(defn boot-and-wait
  "Boot the server and sleep the executing thread until the server has completed booting"
  []
  (boot)
  (wait-till-connected))

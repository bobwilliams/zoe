(ns zoe.global)

(def display-name (atom "Zoe"))
(def server-port (atom 9000))

(defn update-atom [atom value]
  (if value (reset! atom value)))

(defn initialize-atoms [conf]
  (update-atom display-name (or (:display-name conf) "Zoe"))
  (update-atom server-port (or (:server-port conf) 9000)))
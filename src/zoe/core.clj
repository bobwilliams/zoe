(ns zoe.core
  (:gen-class)
  (:require [clojure.java.io :as io]
            [org.httpkit.server :refer :all]
            [ring.util.response :refer :all]
            [compojure.core :refer [defroutes GET POST]]
            [ring.middleware.reload :as reload]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [cheshire.core :as json]
            [zoe.global :as g]
            [zoe.views :as v]))

(def resource-conf (-> "config.json" io/resource))

(defn read-conf [file]
  (json/parse-string (slurp (or file resource-conf)) true))

(defroutes routes
  (GET "/alo" [] "alo bryan!")
  (GET "/" [] (v/instance-view))  
  (route/resources "/static/"))

(defn app-routes [{mode :mode}]
  (if (= mode "prod")
    (handler/site routes)
    (-> #'routes handler/site reload/wrap-reload)))

(defn -main [& [conf-file]]
  (let [conf (read-conf conf-file)
        app (app-routes conf)]
    (g/initialize-atoms conf)
    (run-server app {:port @g/server-port :join? false})))
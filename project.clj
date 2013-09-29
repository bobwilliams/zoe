(defproject zoe "0.1.0-SNAPSHOT"
  :description "Personal Analytics and APIs"
  :url "http://bobalytics.com"
  :main zoe.core
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [http-kit "2.1.8"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-devel "1.1.8"]
                 [clj-http "0.7.4"]
                 [cheshire "5.2.0"]])
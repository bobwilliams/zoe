(ns zoe.views
  (:require [hiccup.core :refer :all]
            [zoe.global :as g]))

(defn common-head [& extras]
  [:head
    [:title @g/display-name]
    [:link {:href "/static/bootstrap/css/bootstrap.min.css" :rel "stylesheet" :media "screen"}]
    [:script {:src "http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"}]
    [:script {:src "/static/bootstrap/js/bootstrap.min.js"}]
    [:script {:src "/static/js/query-builder.js"}]
    extras])

(defn nav-bar []
  [:div.navbar.navbar-default {:role "navigation"}
    [:a.navbar-brand {:href "#"} @g/display-name]
    [:ul.nav.navbar-nav]])

(defn breadcrumb [[name url]]
  [:li
    [:a {:href url} name]])

(defn breadcrumbs [crumbs]
  [:ol.breadcrumb
    (map breadcrumb crumbs)])

(defn instance-view []
  (html
    [:html
      (common-head)
      [:body
        (nav-bar)
        (breadcrumbs [["home" "/"]])
        [:h3 "Welcome"]]]))

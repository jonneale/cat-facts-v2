(ns cat-facts-v2.main
  (:require [cat-facts-v2.handler :as api]
            [cat-facts-v2.views.index :as index]
            [clojure.java.io :as io]
            [environ.core         :refer [env]]
            [ring.adapter.jetty   :as jetty])
  (:gen-class))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty #'api/app {:port port :join? false})))

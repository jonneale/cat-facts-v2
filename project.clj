(defproject cat-facts-v2 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.7.0"]
            [environ/environ.lein "0.2.1"]]
  :min-lein-version "2.0.0"
  :ring    {:handler cat-facts-v2.handler/app
            :port 3007}
  :main    cat-facts-v2.main
  :hooks   [environ.leiningen.hooks]
  :profiles {:uberjar {:aot :all}}
  :uberjar-name "cat-facts-v2-standalone.jar"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [markdown-clj "0.9.57"]
                 [hitman "0.1.0"]
                 [clj-http "1.0.1"]
                 [compojure "1.2.1"]
                 [ring          "1.3.1"]
                 [environ "0.5.0"]
                 [com.draines/postal "1.11.3"]
                 [org.clojure/data.json "0.2.5"]
                ;; [hiccup "1.0.5"]
                 [org.clojure/data.csv "0.1.2"]
                 [clj-time "0.8.0"]
                 [ring-cors                  "0.1.4"]
                 [org.clojure/tools.cli "0.3.1"]])

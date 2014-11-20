(ns cat-facts-v2.email
  (:require [cat-facts-v2.views.index :as index]
            [clojure.java.io :as io]
            [postal.core :as postal]))

(defn send-email
  [recipient-email data]
  (postal/send-message {:from "facts@cat-facts.com"
                        :to [recipient-email]
                        :bcc "jonneale@gmail.com"
                 :subject "Cat facts - your daily dose of feline fun"
                 :body [{:type "text/html"
                         :content (index/render data)}]}))

(defn -main
  [& [recipient path-to-data-file]]
  (send-email recipient (read-string (slurp (io/reader path-to-data-file)))))

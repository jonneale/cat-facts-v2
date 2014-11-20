(ns cat-facts-v2.handler
  (:use     [compojure.core])
  (:require [cat-facts-v2.views.index                                    :as index]
            [compojure.handler                                           :as handler]
            [compojure.route                                             :as route]))

(defroutes main-routes

  (GET "/"
       []
       "Hello")

  (GET "/test-page"
       []
       (index/render {:title "Test Cat Facts!"
                      :recipient-name "Test recipient"
                      :image-folder "test"
                      :facts [["Fact 1" "fact1.jpg"]
                              ["Fact 2" "fact2.jpg"]
                              ["Fact 3" "fact3.jpg"]]
                      :cats-of-the-day [["Caption 1" "daily1.jpg"]
                                        ["Caption 2" "daily2.jpg"]
                                        ["Caption 3" "daily3.jpg"]]}))

  (route/resources "/"))

(def app
  (-> main-routes
      (handler/site)))

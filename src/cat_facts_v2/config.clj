(ns cat-facts-v2.config)

(def env
  (keyword (get (System/getenv)
                "APP_ENV"
                "development")))

(def development?
  (= :development env))

(def production?
  (= :production env))

(def app-base-url
  (if production?
    "http://cat-facts-v2.herokuapp.com"
    ""))

(ns cat-facts-v2.generate
  (:require [cat-facts-v2.views.index :as index]
            [clojure.java.io :as io]))

(defn -main
  [& [path-to-data-file]]
  (println (index/render (read-string (slurp (io/reader path-to-data-file))))))

  (comment (def path "/Users/jonneale/scratch/cat-facts-v2/email-data/email-1.txt")
           (generate-email path))

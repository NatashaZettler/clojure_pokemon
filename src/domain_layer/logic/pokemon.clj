(ns domain-layer.logic.pokemon
  (:require [clojure.pprint :refer [print-table]]))

(defn get-names [results]
  (for [item results] (str (get item "name"))))

(defn list-names [results]
  (let [names (get-names results)
        format-hash-map (map #(hash-map :name %) names)]
    (print-table format-hash-map)
    )
  )
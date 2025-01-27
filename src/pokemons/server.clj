(ns pokemons.server
  (:require [clj-http.client :as http-client]
   [pokemons.endpoints-name :as p.endpoint])
  )

(def just-body (:body (http-client/get p.endpoint/api-url-pokemon
                                       {:query-params {"limit" "20"
                                                       "offset" "1"}}
                                       )))

(defn just-abilities [url] (:body (http-client/get url)))
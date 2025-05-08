(ns pokemons.controller-per-functionality
  (:require [cheshire.core :refer :all]
  ;[clojure.tools.cli :refer [parse-opts]]
   [pokemons.server :as p.server]
           )
  )

(def get-results
  (get-in (parse-string p.server/just-body) ["results"])
  )

(defn get-moves-name [moves]
  (for [item moves] (get-in item ["move" "name"])))

;Procurar informações sobre um pokemon especifico
(defn filter-by-name [name result]
  (filter #(= name (get % "name")) result))

(defn get-url-by-name [name]
  (get (first (filter-by-name name get-results)) "url")
  )

(def get-info-specific-pokemon (p.server/just-abilities (get-url-by-name "squirtle")))
(def parse-abilities (get-in (parse-string get-info-specific-pokemon) ["abilities"]))

(def parse-moves (get-in (parse-string get-info-specific-pokemon) ["moves"]))


;Listar todos os pokemons
(defn get-names [results]
  (for [item results] (str (get item "name"))))

;Ordenar os nomes dos pokemons crescente
(defn sort-names [get-results]
  (println (get-names get-results))
  (sort (get-names get-results)))

;Ordenar os nomes dos pokemons pelo número de letras do próprio nome
(defn sort-names-letter [get-results]
  (println (get-names get-results))
  (sort-by count (get-names get-results)))

;Ordenar os nomes dos pokemons decrescente
(defn sort-names-desc [get-results]
  (println (get-names get-results))
  (sort-by identity #(compare %2 %1) (get-names get-results)))

; Quais suas habilidades?
(defn get-abilities [abilities]
  (for [item abilities] (get-in item ["ability" "name"])))


;Quantos movimentos esse pokemon tem?

(defn qtd-moves [moves]
  (count moves)
  )

;Colocar uma marca/símbolo para identificar que são movimentos
(defn search-moves-by-word [moves branch]
  (map #(str branch %) (get-moves-name moves)))

;Quantos pokemons devem ter as habilidades listadas?

(defn dec-value [value]
  (dec value))

(defn concat-url-seq [url qtd]
  (str url qtd ))

(defn get-all-urls [url qtd vetor]
  (let [new-url (concat-url-seq url qtd)
        new-vetor (conj vetor new-url)] new-vetor)
  )

(get-all-urls "http://pokemon/" 3 ["2er"])

(defn choose-how-many-pokemon-get-info [url qtd vetor]
  (let [dec-qtd (dec-value qtd)
        new-vetor (get-all-urls url qtd vetor)]
    (if (= dec-qtd 0) new-vetor (choose-how-many-pokemon-get-info url dec-qtd new-vetor))
    )
  )



(choose-how-many-pokemon-get-info "https://pokeapi.co/api/v2/pokemon/" 3 [])



(defn request-abilities-from-many-pokemons []
  (let [urls-pokemons (choose-how-many-pokemon-get-info "https://pokeapi.co/api/v2/pokemon/" 3 [])]
    ;(println urls-pokemons)
    (println "\n\n\n\n")
    (map #(p.server/just-abilities %1) urls-pokemons)
    )
  )

(request-abilities-from-many-pokemons)

;many-abilities-from-many-pokemons


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;12. Existe algum movimento com a palavra digitada
(defn existe-movimento-com-palavra-especifica [moviment-name]
    (-> parse-moves

      (map #(get-in % ["move" "name"]))
        ;(some #(= % moviment-name))
        )
    )















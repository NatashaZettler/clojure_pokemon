(ns pokemons.controller-per-functionality
  (:require [cheshire.core :refer :all]
            [clojure.pprint :refer [print-table]]
            ;[clojure.tools.cli :refer [parse-opts]]
            [pokemons.server :as p.server]))

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

(defn sort-names-PRI [get-results]
  (let [sorted-names (sort (get-names get-results))
        names-maps (map #(hash-map :Name %) sorted-names)]
    (print-table names-maps))) ;; vê se você curte esse print!

;Ordenar os nomes dos pokemons pelo número de letras do próprio nome
(defn sort-names-letter [get-results]
  (println (get-names get-results))
  (sort-by count (get-names get-results)))

(defn sort-names-letter-PRI [get-results]
  (println (get-names get-results))
  (sort-by count (get-names get-results))) ; quando você faz o sort-by depois do println, ele não printa o resultado ordenado

;Ordenar os nomes dos pokemons decrescente
(defn sort-names-desc [get-results]
  (println (get-names get-results))
  (sort-by identity #(compare %2 %1) (get-names get-results)))

(defn sort-names-desc-PRI [get-results]
  (println (get-names get-results))
  (sort-by identity #(compare %2 %1) (get-names get-results))) ; mesma coisa aqui, ele não printa o resultado ordenado

; Quais suas habilidades?
(defn get-abilities [abilities]
  (for [item abilities] (get-in item ["ability" "name"])))

(defn get-abilities-PRI [abilities]
  (for [item abilities] (get-in item ["ability" "name"])))  ; que tal tentar usar um map?

;Quantos movimentos esse pokemon tem?
(defn qtd-moves [moves]
  (count moves)
  )

(defn qtd-moves-PRI [moves]
  (println (count moves)))

;Colocar uma marca/símbolo para identificar que são movimentos
(defn search-moves-by-word [moves branch]
  (map #(str branch %) (get-moves-name moves)))

(defn search-moves-by-word-PRI [moves branch]
  (map #(str branch %) (get-moves-name moves)))             ; não vai printar nada

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

(defn just-abilities-parse [url] (get-in (parse-string (p.server/just-abilities url)) ["abilities"]))

(defn request-abilities-from-many-pokemons [num]
  (let [urls-pokemons (choose-how-many-pokemon-get-info "https://pokeapi.co/api/v2/pokemon/" num [])]
    (println "\n")
    (map #(just-abilities-parse %1) urls-pokemons)
    )
  )
(request-abilities-from-many-pokemons 2)

(defn get-abilities-from-more-than-one-pokemon [num]
  (mapv (fn [list] (map #(get-in %1 ["ability" "name"]) list))
        (request-abilities-from-many-pokemons num))
  )

;Comparar se as habilidades de dois pokemons são iguais.

(def my-list (atom []))

(defn get-name-and-abilities [num-pokemons, list]

(let [dec-value (dec-value num-pokemons)
      nth-aux (nth (for [item get-results] (str(get-in item ["name"]) "," (get-in item ["url"]))) dec-value)
      ]
  (swap! list conj nth-aux)
  (println list)
  (if (> num-pokemons 1)
    (get-name-and-abilities dec-value list) list)
  )
  )

(for [item (map #(str/split %1 #",") @my-list)] (second item))
(get-name-and-abilities 3 my-list)

@my-list

(reset! my-list [])

(def my-map-atom (atom {}))
(reset! my-map-atom {})

(defn increment-number [num]
  (+ num 1))

(defn print-pokemons [] (doseq [item (map #(str/split %1 #",") @my-list)]
  (do
    (println "\nPokemon name: \n" (first item) "\n")
    (println "Abilities:")
      (doseq [item (just-abilities-parse (second item))]
          (let [new-item (get-in item ["ability" "name"])]
            (println new-item)
            (swap! my-map-atom assoc new-item (increment-number 1))
          )
        )
    )
  )
  (println "Quantidade de habilidades dos pokemons listados: \n")
  (println @my-map-atom)
  )

(print-pokemons)












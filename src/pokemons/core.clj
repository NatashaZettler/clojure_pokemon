(ns pokemons.core
  (:require [pokemons.controller-per-functionality :as p.controller]
            [pokemons.view :as p.view]))

(p.controller/get-names p.controller/get-results)

;; função separada para printar a escolha
(defn print-choice [choice]
  (println (str "Opção " choice)))

(defn handle-choice [choice]
  (print-choice choice)
  (case choice
    "1" (p.controller/get-names p.controller/get-results)   ; não vai printar nada
    "2" (p.controller/sort-names p.controller/get-results)
    "3" (p.controller/sort-names-letter p.controller/get-results) ; não vai printar nada
    "4" (p.controller/get-abilities p.controller/parse-abilities) ; não vai printar nada
    "5" (p.controller/qtd-moves p.controller/parse-moves)
    "6" (println "Funcionalidade não implementada ainda")
    "7" (println "Funcionalidade não implementada ainda")
    "8" (p.controller/search-moves-by-word p.controller/parse-moves "MOVE - ")
    "9" (println (distinct (p.controller/get-abilities-from-more-than-one-pokemon 2)))
    "10" (p.controller/get-url-by-name "squirtle")
    "11" (p.controller/sort-names-desc p.controller/get-results)
    "12" :exit
    (println "Opção inválida, tente novamente.")))

(defn menu-loop []
  (loop []
    (p.view/create-a-menu)
    (let [choice (read-line)
          result (handle-choice choice)]
      (when (not= result :exit)
        (recur)))))

;(menu-loop)

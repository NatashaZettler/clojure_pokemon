(ns pokemons.core
  (:require [pokemons.controller-per-functionality :as p.controller]
            [pokemons.view :as p.view]))

(p.controller/get-names p.controller/get-results)

;; função separada para printar a escolha
(defn print-choice-PRI [choice]
  (println (str "Opção " choice)))

(defn handle-choice [choice]
  (case choice
    "1" (do (println "Você escolheu Opção 1")
            (p.controller/get-names p.controller/get-results)
            )
    "2" (do (println "Você escolheu Opção 2")
            (p.controller/sort-names p.controller/get-results)
            )
    "3" (do (println "Você escolheu Opção 3")
            (p.controller/sort-names-letter p.controller/get-results)
            )
    "4" (do (println "Você escolheu Opção 4")
            (p.controller/get-abilities p.controller/parse-abilities)
            )
    "5" (do (println "Você escolheu Opção 5")
            (p.controller/qtd-moves p.controller/parse-moves)
            )
    "6" (do (println "Você escolheu Opção 6")
            (p.controller/print-pokemons)
            )
    "7" (do (println "Você escolheu Opção 7")
            ;Buscar movimentos que comecem com uma palavra especifica
            )
    "8" (do (println "Você escolheu Opção 8")
            (p.controller/search-moves-by-word p.controller/parse-moves "MOVE - ")
            )
    "9" (do (println "Você escolheu Opção 9")
            (distinct (p.controller/get-abilities-from-more-than-one-pokemon 2))
            )
    "10" (do (println "Você escolheu Opção 10")
             (p.controller/get-url-by-name "squirtle")
             )
    "11" (do (println "Você escolheu Opção 11")
             (p.controller/sort-names-desc p.controller/get-results)
             )
    "12" (do (println "Encerrando o sistema...")
             (System/exit 0))
    (println "Opção inválida, tente novamente.")))

(defn handle-choice-PRI [choice]
  (print-choice-PRI choice)
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
    (let [choice (read-line)]
      (handle-choice choice)
      (recur))))

(defn menu-loop-PRI []
  (loop []
    (p.view/create-a-menu)
    (let [choice (read-line)
          result (handle-choice choice)]
      (when (not= result :exit)
        (recur)))))

;(menu-loop)

(ns pokemons.core
  (:require [pokemons.controller-per-functionality :as p.controller]
            [pokemons.view :as p.view]))

(p.controller/get-names p.controller/get-results)

;; função separada para printar a escolha
(defn print-choice [choice]
  (println (str "Opção " choice)))

(defn handle-choice-old [choice]
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
            (p.controller/print-pokemons 3)
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
<<<<<<< HEAD
            )
    "12" (do (println "Você escolheu Opção 12")
             (p.controller/))
    "13" (do (println "Encerrando o sistema...")
            (System/exit 0))
=======
             )
    "12" (do (println "Encerrando o sistema...")
             (System/exit 0))
>>>>>>> 61509d1f9475390bb26c07da7744593dd24e4277
    (println "Opção inválida, tente novamente.")))

(defn handle-choice [choice]
  (print-choice choice)
  (case choice
    "1" (p.controller/list-names p.controller/get-results)
    "2" (p.controller/sort-names p.controller/get-results)
    "3" (p.controller/sort-names-letter p.controller/get-results) ; não vai printar nada
    "4" (p.controller/get-abilities p.controller/parse-abilities)
    "5" (p.controller/qtd-moves p.controller/parse-moves)
    "6" (p.controller/print-pokemons 3)
    "7" (println "Funcionalidade não implementada ainda")
    "8" (p.controller/search-moves-by-word p.controller/parse-moves "MOVE - ")
    "9" (println (distinct (p.controller/get-abilities-from-more-than-one-pokemon 2)))
    "10" (p.controller/get-url-by-name "squirtle")
    "11" (p.controller/sort-names-desc p.controller/get-results)
    "12" :exit
    (println "Opção inválida, tente novamente.")))

(defn menu-loop-old []
  (loop []
    (p.view/create-a-menu)
    (let [choice (read-line)]
      (handle-choice choice)
      (recur))))

(defn menu-loop []
  (loop []
    (p.view/create-a-menu)
    (let [choice (read-line)
          result (handle-choice choice)]
      (when (not= result :exit)
        (recur)))))

;(menu-loop)
<<<<<<< HEAD





;Comparar se as habilidades de dois pokemons são iguais
;Buscar movimentos que comecem com uma palavra especifica
;
;zipmap
;match
;:-
;^:private
;s/defn
;cond
;future-entries-reversal* - funcao com *
;defschema
;defmethod
;defmulti
;defn-
;some
;maybe
;juxt - quero executar essas duas funcões ou mais
;comp
;case
;clojure
;:-
;^:private
;s/defn
;cond
;future-entries-reversal* - funcao com *
;defschema
;defmethod
;defmulti
;defn-
;if-let
;when-let
;some
=======
>>>>>>> 61509d1f9475390bb26c07da7744593dd24e4277

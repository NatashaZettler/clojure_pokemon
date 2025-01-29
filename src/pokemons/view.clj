(ns pokemons.view
    (:require [pokemons.utils :as p.utils])
  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;MENU;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def date-time (p.utils/date-time-user-use-system))

(defn create-a-menu []
  (println "Menu sobre pokemons")
  date-time
  (println "1. Listar todos os pokemons")
  (println "2. Ordenar os nomes dos pokemons crescente")
  (println "3. Ordenar os nomes dos pokemons pelo número de letras do próprio nome")
  (println "4. Quais suas habilidades?")
  (println "5. Quantos movimentos esse pokemon tem?")
  (println "6. Comparar se as habilidades de dois pokemons são iguais")
  (println "7. Buscar movimentos que comecem com uma palavra especifica")
  (println "8. Colocar uma marca/símbolo para identificar que são movimentos")
  (println "9. Quantos pokemons devem ter as habilidades listadas e liste as mesmas e não repetidas? ")
  (println "10. Procurar informações sobre um pokemon especifico")
  (println "11. Ordenar os nomes dos pokemons decrescente")
  (println "12. Sair do sistema")
  )


(defn create-a-menu-PRI []
  (let [date-time (p.utils/date-time-user-use-system)] ; criando o date-time aqui dentro pra ele sempre atualizar
    (println "############### Menu sobre pokemons ############### [" date-time "]")
    (doseq [line ["1. Listar todos os pokemons"
                  "2. Ordenar os nomes dos pokemons crescente"
                  "3. Ordenar os nomes dos pokemons pelo número de letras do próprio nome"
                  "4. Quais suas habilidades?"
                  "5. Quantos movimentos esse pokemon tem?"
                  "6. Comparar se as habilidades de dois pokemons são iguais"
                  "7. Buscar movimentos que comecem com uma palavra especifica"
                  "8. Colocar uma marca/símbolo para identificar que são movimentos"
                  "9. Quantos pokemons devem ter as habilidades listadas e liste as mesmas e não repetidas?"
                  "10. Procurar informações sobre um pokemon especifico"
                  "11. Ordenar os nomes dos pokemons decrescente"
                  "12. Sair do sistema"]]
      (println line))))



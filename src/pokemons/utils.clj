(ns pokemons.utils
  (:import [java.time LocalDateTime]
           [java.time.format DateTimeFormatter]))

;Data e hora em que o usuário usou o sistema
(defn date-time-user-use-system []
  (let [now (LocalDateTime/now)
        formatter (DateTimeFormatter/ofPattern "dd-MM-yyyy HH:mm:ss")]
    (.format now formatter)))
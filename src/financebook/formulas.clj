(ns financebook.formulas)

(defn juro-I [valor-presente-pv taxa-de-juros-i]
  (* valor-presente-pv taxa-de-juros-i))

(defn valor-futuro-fv [valor-presente-pv taxa-de-juros-i]
  (* valor-presente-pv (+ 1 taxa-de-juros-i)))

(defn valor-presente-pv [valor-futuro-pv taxa-de-juros-i]
  (/ valor-futuro-pv (+ 1 taxa-de-juros-i)))

(defn taxa-juros-i [valor-futuro-fv valor-presente-pv]
  (let [divisao (/ valor-futuro-fv valor-presente-pv)
        ](bigdec(- divisao 1)))
  )

(juro-I 1000 0.22M)

(valor-futuro-fv 1000 0.22M)

(valor-presente-pv 1220 0.22M)

(taxa-juros-i 1220 1000)

;Juros simples

(defn fator-de-capitalizacao [taxa-de-juros-i parcelas] (
                                  + 1 (* taxa-de-juros-i parcelas)
                                  ))
(defn valor-present-juros-simples [valor-futuro taxa-de-juros-i parcelas]
  (/ valor-futuro (fator-de-capitalizacao taxa-de-juros-i parcelas))
  )
(fator-de-capitalizacao 0.08 12)
(bigdec(valor-present-juros-simples (valor-futuro-fv 1000 0.08M) 0.08 12))

















(ns ol-eval.core)

;The target form
;(key-if test
;  :then exp1 exp2 ...
;  :else exp3 exp4 ...)

;Macro to implement the target form
(defmacro key-if
  "Keyed conditional"
  [test & more]
  ;Break out the keyed conditionals we were passed
  (def thenseq (take-while #(not= % :else) (drop-while #(not= % :then) more)))
  (def elseseq (take-while #(not= % :then) (drop-while #(not= % :else) more)))

  ;If the :then and/or :else conditionals are not blank process them
  (if (eval test)
    (if-not (empty? thenseq)
      (case (count thenseq)
        1 nil
        2 (do (nth thenseq 1))
        3 (do (eval (nth thenseq 1)) (nth thenseq 2))))
    (if-not (empty? elseseq)
      (case (count elseseq)
        1 nil
        2 (do (nth elseseq 1))
        3 (do (eval (nth elseseq 1)) (nth elseseq 2))))))

(defn product [term a next b]
  (if (> a b)
      1
      (* (term a)
         (product term (next a) next b))))

(defn factorial [n]
  (product
   (fn [x] x)
   1
   (fn [x] (+ x 1))
   n))

; pi/4 = 2/3*4/3*4/5*6/5*6/7*8/7*....
(defn pi [n]
  (def term
    (fn [a]
      (if (even? a)
        (/ (+ a 2) (+ a 1))
        (/ (+ a 1) (+ a 2)))))
  (* 4.0 (product2 term 1 inc n)))

(defn product2 [term a next b]
  (def iter (fn [a result]
              (if (> a b)
                result
                (iter (next a) (* result (term a))))))
  (iter a 1))

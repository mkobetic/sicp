(defn cont-frac-i [n d k]
  (def iter
    (fn [k rest]
      (if (> k 0)
        (recur (- k 1) (/ (n k) (+ (d k) rest)))
        rest)))
  (iter k 0))

(defn cont-frac [n d k]
  (def rec
    (fn [i]
      (if (> i k)
        0
        (/ (n i)
           (+ (d i) (rec (+ i 1)))))))
  (rec 1))

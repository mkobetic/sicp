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

; 1.38
; e - 2: N = 1,1,... D = 1,2,1,1,4,1,1,6,1,1,8,...

(defn e-n [i] 1.0)
(defn e-d [i]
  (if (> i 1)
    (if (= (mod (- i 2) 3) 0)
      (* (+ (quot (- i 2) 3) 1) 2)
      1)
    1))
(defn e [k]
  (+ 2 (cont-frac e-n e-d k)))

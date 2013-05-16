; 1.41
(defn double [f]
  (fn [x] (f (f x))))

; 1.42
(defn compose [f g]
  (fn [x] (f (g x))))

; 1.43
(defn repeated [f n]
  (if (> n 1)
    (compose f (repeated f (- n 1)))
    f))
; 1.44
(defn smooth [f dx]
  (fn [x] (/ (+ (f (+ x dx)) (f x) (f (- x dx))) 3)))

(defn n-fold-smooth [f dx n]
  ((repeated (fn [f] (smooth f dx)) n) f))

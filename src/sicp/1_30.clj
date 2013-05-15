(defn sum [term a next b]
      (if (> a b)
      	  0
	  (+ (term a)
	     (sum term (next a) next b))))

(defn integral [f a b dx]
  (* (sum f (+ a (/ dx 2.0)) (fn [x] (+ x dx)) b)
     dx))

(defn sum2 [term a next b]
  (def iter (fn [a result]
              (if (> a b)
                result
                (iter (next a) (+ result (term a))))))
  (iter a 0))

(defn integral2 [f a b dx]
  (* (sum2 f (+ a (/ dx 2.0)) (fn [x] (+ x dx)) b)
     dx))


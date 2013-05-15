(defn sum [term a next b]
      (if (> a b)
      	  0
	  (+ (term a)
	     (sum term (next a) next b))))

(defn integral [f a b dx]
  (* (sum f (+ a (/ dx 2.0)) (fn [x] (+ x dx)) b)
     dx))

(defn integral2 [f a b n]
  (let [ h (/ (- b a) n)
        next (fn [x] (+ x (* 2 h)))]
    (* (+ (f a)
          (f b)
          (sum (fn [x] (* 4 (f x))) (+ a h) next (- b h))
          (sum (fn [x] (* 2 (f x))) (+ a (* 2 h)) next (- b h)))
       (/ h 3))))

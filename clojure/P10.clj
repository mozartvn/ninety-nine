; P10 Run-length encoding of a list.

; Mapping
(defn f1 [ls]
  (map (fn [l] (list (count l) (first l))) ls))

; Mapping, again
(defn f2 [ls]
  (map list (map count ls) (map first ls)))

; Folding
(defn f3 [ls]
  (reduce (fn [acc l] (cons (list (count l) (first l)) acc)) '() (reverse ls)))

; Recursion
(defn f4 [ls]
  (if (seq ls)
    (let [h (first ls) t (rest ls)]
      (cons (list (count h) (first h)) (f4 t)))
    '()))

; Tail recursion
(defn f5 [ls]
  (loop [acc '() l ls]
    (if (seq l)
      (let [h (first l) t (rest l)]
        (recur (cons (list (count h) (first h)) acc) t))
      (reverse acc))))
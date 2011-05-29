;;
; Stephen Mann
; 29 May 2011
;
; Print word frequences of the input file to the output file.  Sample call:
;
;     clj count-words2.clj sampleFile.txt output.txt
;

(ns count-words
  (:require [clojure.string :as str]))

(defn get-word-counts [text]
  (reduce
    (fn [words word] (assoc words word (inc (words word 0))))
    {}
    (str/split (.toLowerCase text) #"\W+")))

(defn get-pretty-string [word-counts]
  (str/join "\n" (map (fn [[word freq]] (str freq ": " word))
                      (sort-by val word-counts))))

(time
  (let [in  (first  *command-line-args*)
        out (second *command-line-args*)]
    (->> (slurp in)
      get-word-counts
      get-pretty-string
      (spit out))))

;;
; Stephen Mann
; 29 May 2011
;
; Print suffix frequences of the input file to the output file.  Suffixes
; marked with a "_" prefix represent the entire word.
;
; Sample call:
;
;     clj count-suffixes.clj sampleFile.txt output.txt
;

(ns count-words
  (:require [clojure.string :as str]))

(defn skip-second [[a _ & many]]
  (cons a many))

(defn suffixes [word]
  (let [marked-word (str "_" word)]
    (skip-second (map (partial subs marked-word)
                      (range (dec (.length marked-word)))))))

(defn get-suffix-counts [text]
  (let [all-words (str/split (.toLowerCase text) #"\W+")
        all-suffixes (flatten (map suffixes all-words))]
    (reduce #(assoc %1 %2 (inc (%1 %2 0))) {} all-suffixes)))

(defn get-pretty-string [word-counts]
  (str/join "\n" (map (fn [[word freq]] (str freq ": " word))
                      (sort-by val word-counts))))

(time
  (let [[in out] *command-line-args*]
    (->> (slurp in)
      get-suffix-counts
      get-pretty-string
      (spit out))))

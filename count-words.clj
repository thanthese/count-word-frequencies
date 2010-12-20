;;
; Stephen Mann
; December 20, 2010
;
; Trying that counting-word-frequency program again, this time in clojure.
;

(ns tokenize
 (:import (java.io BufferedWriter FileWriter)))

(defn split-words [text]
 "split text into a list of words"
 (re-seq #"\w+" text))

(defn calculate-frequencies [words]
 "convert list of words to a word-frequency hash"
 (reduce (fn [words word] (assoc words word (inc (get words word 0))))
  {}
  words))

(defn pretty-print [words-hash]
 (map (fn [[a b]] (str b ": " a "\n")) words-hash))

(defn write-to-file [file-name lines]
 (with-open [wtr (BufferedWriter. (FileWriter. file-name))]
  (doseq [line lines] (.write wtr line))))

(defn sort-words-by-frequency [words-hash]
 (sort
  (fn [[word1 freq1] [word2 freq2]] (< freq1 freq2))
  words-hash))

(defn fix-case [words]
 (map #(.toLowerCase %) words))

(time
 (write-to-file "output.txt"
  (pretty-print
   (sort-words-by-frequency
    (calculate-frequencies
     (fix-case
      (split-words
       (slurp "sampleFile.txt"))))))))

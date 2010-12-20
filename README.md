# Count word frequencies

## The Problem

Create a command-line app to count how many times each words appears in a text file.  Specifics:

- Read from `sampleFile.txt,` write to `output.txt`.
- Pretty-print the results.
- Lower-case all words.
- Sort results by frequency.

## The Challenge

Make it run as quickly as possible.

## Current Standings

Shockingly, the python implementation is currently the fastest.  By *a lot*.

Running the apps on my machine:

    thanthese@Ix:~/clojure/count-word-frequencies$ time python wordsInAFile.py sampleFile.txt output.txt

    real	0m0.319s
    user	0m0.280s
    sys	0m0.040s
    thanthese@Ix:~/clojure/count-word-frequencies$ time clojure count-words.clj

    real	0m3.499s
    user	0m6.150s
    sys	0m0.370s


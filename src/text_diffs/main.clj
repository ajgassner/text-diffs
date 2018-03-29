(ns text_diffs.main
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as str])
  (:import (name.fraser.neil.plaintext diff_match_patch)
           (com.github.difflib UnifiedDiffUtils DiffUtils)))

(defn print-seq [lines]
  (doseq [line lines]
    (println line)))

(defn du-uni-diff [str1 str2]
  (println "=== Diff Utils unified format (unidiff) ===")
  (print-seq (UnifiedDiffUtils/generateUnifiedDiff "original" "modified" (str/split str1 #"\n") (DiffUtils/diff str1 str2) 10)))

(defn dmp-uni-diff [str1 str2]
  (println "=== DMP unified format (unidiff) ===")
  (let [dmp (new diff_match_patch)]
    (println (.patch_toText dmp (.patch_make dmp str1 str2)))))

(defn dmp-diff [str1 str2, html?]
  (println "=== DMP diff ===")
  (let [dmp (new diff_match_patch)
        diff (.diff_main dmp str1 str2)]
    (.diff_cleanupSemantic dmp diff)
    (if html?
      (println (.diff_prettyHtml dmp diff))
      (print-seq diff))))

(defn -main []
  (let [orig (slurp (io/resource "first.html"))
        mod (slurp (io/resource "second.html"))]
    (time (du-uni-diff orig mod))
    (time (dmp-uni-diff orig mod))
    (time (dmp-diff orig mod true))
    (time (dmp-diff orig mod false))))
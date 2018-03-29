(defproject text-diffs "0-SNAPSHOT"
  :description "A simple program to test diff libraries"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.github.wumpz/diffutils "2.2":exclusions [org.eclipse.jgit]]
                 [google-diff-match-patch/google-diff-match-patch "0.1"]]
  :main text_diffs.main)
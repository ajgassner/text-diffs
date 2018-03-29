(defproject text-diffs "0-SNAPSHOT"
  :description "A simple program to test diff libraries"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.github.wumpz/diffutils "2.2"]]
  :java-source-paths ["src/java"]
  :main text_diffs.main)
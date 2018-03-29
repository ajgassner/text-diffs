# text-diffs

A simple program to test diff libraries.

## Usage

`lein run`

## Comments

* DiffUtils has a dependency to jGit, diff_match_patch is smaller, just one class
  * Dependency can be excluded for unidiff creation
* DiffUtils has a better API
* DiffUtils: Better unidiff support?! DMP output has to be urldecoded! https://github.com/google/diff-match-patch/wiki/Unidiff
* https://codemirror.net/mode/diff/index.html or Diff2Html can be used to render the unidiff output
* HTML Rendering example: https://jsfiddle.net/7eepo3b9/34/
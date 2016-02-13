---
title: Building and testing a parser
layout: page
---


## Configuration

- [configuration](configuration)

## Prerequisites

- [Stuttgart FST toolbox](http://www.cis.uni-muenchen.de/~schmid/tools/SFST/).  If not installed in `/usr/bin`, edit `fstconf.grade` with the full path to `fst-compiler`.
- `make`.  If not in `/usr/bin`, edit `fstconf.grade` with the full path to `make`.

## What gets built

- `gradle fst` builds the binary FST in `build/fst/morphology.a`.   You can use this transducer with any of the SFST tools.  E.g., to analyze a list of strings in a file, you can use `fst-infl build/fst/morphology.a <FILENAME>`.
- `gradle fstgen` builds a "switched" binary FST in `build/fst/bulkgen.a`.  You can use this transducer with `fstgen` for batch generation of specified forms, e.g., with `fst-infl build/fst/bulkgen.a <FILENAME>`.


Set the orthography to use in the `ortho` system property, e.g., from command line

    gradle -Portho=attic fst


## Testing system

### Unit tests

Many unit tests.  Build parsers for both Attic and literary Greek orthography with the  included shell script: `sh build-fst.sh`.  Run `gradle test` to run unit tests, `gradle conc` to build dynamically tested specifications.  (Output of latter in `build/concordion-formatted`).


### FST REPL


    fst-mor build/$ORTHO/greek.a

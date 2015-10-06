
# Tour of the Greek FST

## Background

The build system in this project lets you build a parser for a specified set of stem lexica, using a specified set of inflectional rules.

## Overview of what's here

The two-way morphological analyzer is defined in `morphology.fst`. (The accompanying gradle build compiles this to `morphology.a`).  It is a finite state transducer (FST) that works by joining together *stems* and *inflectional patterns*.


- Stems are dynamically loaded from text files (named either `.fst` or `.tsv`) in the specified stems directory (by default, `fst/stems`).  (Add link here on syntax of stems files.)
- Inflectional patterns are dynamically loaded from compiled transducers.  A core set of rules is defined in `inflection.fst` (which compiles to `inflection.a`).  Optionally, additional patterns are compiled and loaded from files named `.fst` in the specified rules directory (by default, `fst/rules`). (Add link here on syntax of rules files.)
- The vocabulary used in the FST is defined in `symbols.fst`.

The stem-rule combinations are submitted to a transducer defined in `acceptor.fst` (which compiles to `acceptor.a`).  This filters out any combinations that do not satisfy the definition of a valid morphological analysis.





## Using the gradle build system

Tasks:

- `gradle fst` builds the FST in `fst/build/fst/morphology.a`
- `gradle fstgen` builds a "switched" FST in `fst/build/fst/bulkgen.a`
- `gradle raw` builds a debugging tool to display the raw morphological data in `fst/build/fst/raw.a`

Configuration:  set in file `fstconf.gradle`.  Values may be overriden on the command line with `-P` flag. E.g.,

    gradle -Pstemsdir=/altnerate/directory/for/stems fst



## Using the transducer with SFST tools

Examples:

- batch analyze lists of input:  `fst-mor morphology.a`
- batch generate forms from analyses:  `fst-infl bulkgen.a`
- print the graph of the transducer: `fst-print morphology.a`
- generate a visual graph: `fst-print morphology.a | perl fst2dot.pl - | dot -T png -o morphology.png`


## More on definitions

- not treating compound forms as a morphological mapping
- not treating part of speech in traditional sense: reflects instead the analytical categories (which *are* traditional!)



## Testing

Two testing systems are included.  Invoke them with:

- `gradle test`.  Unit tests for system development.
- `gradle analyseTests`.  Tests and analyses a dynamically defined set of stems and inflectional rules.  You can use this to debug and develop your own parser.


Also this: `gradle -b core_test_build.gradle <TASK>`


## Utilities and debugging

### transducers

- `rawmorph.a`
- `rawlex.a`

### The `utils` directory

Presume that "fst/utils" file are used from greekutils root, so go ahead and embed references to included files in relative terms

This contrasts with src files, which have a gradle filter expression, and are compiled to explicit path references.

Explain this in docs.

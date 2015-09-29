
# Tour of the Greek FST


The two-way morphological analyzer is defined in `morphology.fst`. (The accompanying gradle build compiles this to `morphology.a`).  It is a finite state transducer (FST) that works by joining together *stems* and *inflectional patterns*.


- Stems are dynamically loaded from text files (named either `.fst` or `.tsv`) in the specified stems directory (by default, `fst/stems`).  (Add link here on syntax of stems files.)
- Inflectional patterns are dynamically loaded from compiled transducers.  A core set of rules is defined in `inflection.fst` (which compiles to `inflection.a`).  Optionally, additional patterns are compiled and loaded from files named `.fst` in the specified rules directory (by default, `fst/rules`). (Add link here on syntax of rules files.)
- The vocabulary used in the FST is defined in `symbols.fst`.

The stem-rule combinations are submitted to a transducer defined in `acceptor.fst` (which compiles to `acceptor.a`).  This filters out any combinations that do not satisfy the definition of a valid morphological analysis.





## Using the gradle build system

Tasks:

- `gradle fst` builds the FST in `fst/build/fst/morphology.a`
- `gradle fstgen` builds a "switched" FST in `fst/build/fst/bulkgen.a`

Configuration:  set in file `fstconf.gradle`.  Values may be overriden on the command line with `-P` flag. E.g.,

    gradle -Pstemsdir=/altnerate/directory/for/stems fst



## Using the transducer with SFST tools

Examples:

- batch analyze lists of input:  `fst-mor morphology.a`
- batch generate forms from analyses:  `fst-infl bulkgen.a`
- print the graph of the transducer: `fst-print morphology.a`
- generate a visual graph: `fst-print morphology.a | perl fst2dot.pl - | dot -T png -o morphology.png`


# Tour of the Greek FST


The two-way morphological analyzer is defined in `morphology.fst`. (The accompanying gradle build compiles this to `morphology.a`).
It is a finite state transducer (FST) that works by joining together *stems* and *inflectional patterns*.


- Stems are dynamically loaded from text files (named either `.fst` or `.tsv`) in the specified stems directory (by default, `fst/stems`).  (Add link here on syntax of stems files.)
- Inflectional patterns are dynamically loaded from a core set of rules defined in `inflection.fst` (which compiles to `inflection.a`).  Optionally, additional patterns are loaded from files (named `.fst`) in the specified rules directory (by default, `fst/rules`). (Add link here on syntax of rules files.)
- The vocabulary used in the FST is defined in `symbols.fst`.



## The gradle build system

Tasks:

- `gradle fst` builds the FST in `fst/build/fst/morphology.a`
- `gradle fstgen` builds a "switched" FST in `fst/build/fst/bulkgen.a`

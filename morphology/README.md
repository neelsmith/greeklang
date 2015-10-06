#fst#

A finite state transducer for Greek morphology, built with the [Stuttgart FST toolbox](http://www.cis.uni-muenchen.de/~schmid/tools/SFST/).


## Design requirements


- supports dynamically loaded sets of endings easily specified in text files
- supports dynamically loaded sets of inflectional rules (relatively) easily specified in text files
- explicitly enforced case-insensitive ASCII representation of polytonic Greek

## Verifying analysis by synthesis

The FST is one (central) component of a larger, comprehensive analytical system.  The FST works on forms stripped of accents.  It can generate analyses very efficiently even on extremely large sets of input data.  To verify that a given analysis is correct, the build system can algorithmically add to the stripped string the accent appropriate for a given analysis, and compare this with the intially submitted form.



## Prerequisites

- [Stuttgart FST toolbox](http://www.cis.uni-muenchen.de/~schmid/tools/SFST/).  If not installed in `/usr/bin`, edit `fstconf.grade` with the full path to `fst-compiler`.
- `make`.  If not in `/usr/bin`, edit `fstconf.grade` with the full path to `make`.

## What gets built

- `gradle fst` builds the binary FST in `build/fst/morphology.a`.   You can use this transducer with any of the SFST tools.  E.g., to analyze a list of strings in a file, you can use `fst-infl build/fst/morphology.a <FILENAME>`.
- `gradle fstgen` builds a "switched" binary FST in `build/fst/bulkgen.a`.  You can use this transducer with `fstgen` for batch generation of specified forms, e.g., with `fst-infl build/fst/bulkgen.a <FILENAME>`.

## Overview of source contents

- Basic morphological parsing of ancient Greek is in `src`
- lexica of stems are in `stems/*fst`
- inflectional rules are in `rules/*fst`
- user definable tags may be added to either stems or rules.  Examples included for tag `<epic>`.

## Extending contents


### User-defined tagging of forms

Additional tags may be added to the list in `tags/extratags.fst`.  Once they are in that list they may be used with entries in either the lexica of stems or the sets of inflectional rules (see following).

### Lexica of stems

- add a `.fst` file to the `stems` directory
- format entries as `STEM<PartOfSpeech><morphtags>+`

`PartOfSpeech` and `<morphtags>` should be drawn from lists defined in `symbols.fst`.


### Inflectional rules

Additional corpus-specific inflectional rules may be added in `.fst` files in the `rules` directory.

Rules are written in the syntax of SFST-PL, and the file should define an individual transducer for a set of rules.  In the absence of adequate documentation here, see the examples in the `inflection.fst` file.

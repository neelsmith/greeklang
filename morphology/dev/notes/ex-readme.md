#fst#


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

#fst#

A finite state transducer for Greek morphology, built with the
[Stuttgart FST toolbox](http://www.cis.uni-muenchen.de/~schmid/tools/SFST/).


## Design requirements


- dynamically loaded sets of endings easily specified in text files
- dynamically loaded inflectional rules (relatively) easily specified in text files
- case-insensitive handling of surface strings
- FST ignores accents in generation:  they should be algorithmically added based on mophological identification of string

## Overview of contents

- Basic morphological parsing of ancient Greek is in `src`
- lexica of stems are in `stems/*fst`
- inflectional rules are in `rules/*fst`
- user definable tags may be added to either stems or rules.  Examples included for tag `<epic>`.

## Extending contents

### lexica of stems

- add a `.fst` file to the `stems` directory
- format entries as `STEM<PartOfSpeech><morphtags>+`

`PartOfSpeech` and `<morphtags>` should be drawn from lists defined in `symbols.fst`.

Additional tags may be added to the list in 

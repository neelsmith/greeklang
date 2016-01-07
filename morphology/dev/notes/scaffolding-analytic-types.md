# Scaffolding inflectional types

The results of a morphological analyses include analytical data belonging to one of eight types enumerated in `AnalyticalType`.


## Get a type through the FST pipeline

The following mods were required to add a new analytical type (here, added indeclinable type)


### Stem data and inflectional patterns
- build.gradle.  Add method to build appropriate `.fst` format stem lexicon from `.csv` source.
- √ src/core_inflection/*ORTHOGRAPHY*/core_inflection/inflection/*MORPHTYPE*.fst.  Inflectional rules for each type in a given orthography.  Added placeholders for all eight classes for *ORTHOGRAPHY*=greek.
- √ src/core_inflection/*ORTHOGRAPHY*/core_inflection/inflection.fst.  Include  reference to implementation of inflectional type.  Done for *ORTHOGRAPHY*=greek.
- √ src/core_inflection/*ORTHOGRAPHY*/core_inflection/makefile.  Include implementation of each type to `make` dependencies for building this orthography.

### Acceptor transducers to verify format of stem-inflection pairing

- √ src/fst/symbols/stemtypes.fst Add new analytic type to alphabet of symbols.
- src/fst/acceptors/*MORPHTYPE*.fst. Generic acceptor for each type.
- √ src/fst/acceptor.fst.  Add new type to chain of acceptors.
- √ modified:   src/fst/makefile. Add make dependency for acceptor.a on new acceptor.


## Process the FST results in the parser

The following mods were required to add a new analytical type (here, added indeclinable type)

- √ referenceCollections/*.csv.  Collections identifying morphological forms.
- √ src/fst/collectionAbbreviations.csv.  Register abbreviations for URNs identifying inflectional patterns.
- √ src/main/groovy/edu/holycross/shot/greekmorph/*Form.groovy: implementations of CitableId
    - AdjectiveForm
    - AdverbForm
    - IndeclinableForm
    - InfinitiveForm
    - NounForm
    - ParticipleForm
    - VerbalAdjectiveForm
    - VerbForm
- √ src/main/groovy/edu/holycross/shot/greekmorph/MorphForm.groovy. Generic morphological form including a form belonging to one of the 8 enumerated types.
- √ src/main/groovy/edu/holycross/shot/greekmorph/FstAnalysisParser.groovy
- src/main/groovy/edu/holycross/shot/greekmorph/*PARSER_FOR_ORTHOGRAPHY*.groovy




.wq

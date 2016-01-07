# Scaffolding inflectional types

The results of a morphological analyses include analytical data belonging to one of eight types enumerated in `AnalyticalType`.


## Get a type through the FST pipeline

The following mods were required to add a new analytical type (here, added indeclinable type)

- modified:   build.gradle.  Added method to build appropriate stem lexicon from `.csv` source
- modified:   src/core_inflection/greek/core_inflection/inflection.fst.  Included new inflectional type
- new file:   src/core_inflection/greek/core_inflection/inflection/indeclinfl.fst.  Inflectional rules for the new type in a given orthography.
- modified:   src/core_inflection/greek/core_inflection/makefile.  Add new implementation to make dependencies for building this orthography.
- modified:   src/fst/acceptor.fst.  Add new type to chain of acceptors.
- modified:   src/fst/makefile. Add make dependency for acceptor.a on new acceptor.
- modified:   src/fst/symbols/stemtypes.fst Add new analytic type to alphabet of symbols.
- modified: src/fst/acceptors/indeclinable.fst.  Implement generic acceptor for new type (still requires implementation in a given orthograph).


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
- src/main/groovy/edu/holycross/shot/greekmorph/FstAnalysisParser.groovy
- new file:   
- modified:   src/main/groovy/edu/holycross/shot/greekmorph/LiteraryGreekParser.groovy




.wq

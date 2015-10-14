## Building lexica of morphological stems

The FST engine reads one or more lexica of morphological stems that are simply structured strings in the FST's alphabet of symbols.  It is possible to write these directly (manually, or from scripts), and place them in the `stems` directory for compilation of a corpus-specific parser.  The file names should have a .`fst` extension with one lexicon statement per line in the FST string format documented elsewhere.

It is also possible to generate these `.fst` files from tabular data in `.csv` or `.tsv` files using a more readable ASCII transcription of the stem's Greek strings.

The directory `stems_lexicon` has subdirectories for four parts of speech, with required formats for stems of each type.  Place your `.csv` or `.tsv` files there, and they will be converted to `.fst` files in the `stems` directory prior to compilation of the parser.


### Formats

### verbs: simplex form

Five columns:

    StemUrn,LexicalEntity,StemString,PartOfSpeech,MorphologicalClass

Documentation for verbs:  defined set of morphological classes.


### verbs: compounds

Three columns:

    CompoundEntity,StemString,SimplexEntity

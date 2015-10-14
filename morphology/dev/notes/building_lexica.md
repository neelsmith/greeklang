## Building lexica of morphological stems

The FST engine reads one or more lexica of morphological stems that are simply structured strings in the FST's alphabet of symbols.  It is possible to write these directly (manually, or from scripts), and place them in a designated stems directory for compilation of a corpus-specific parser.  (The actual directory is defined by the gradle setting `stemsdir` in `fstconf`.) The file names should have a .`fst` extension with one lexicon statement per line in the FST string format documented elsewhere.

It is also possible to generate these `.fst` files from tabular data in `.csv` or `.tsv` files using a more readable ASCII transcription of the stem's Greek strings.

A stems source directory (defined by the gradle variable `stemssrcdir`) has subdirectories for four parts of speech, with required formats for stems of each type.  Place your `.csv` or `.tsv` files there, and they will be converted to `.fst` files in the `stems` directory prior to compilation of the parser.


### Formats

### verbs: simplex form

Five columns:

    StemUrn,LexicalEntity,StemString,PartOfSpeech,MorphologicalClass,Tags

Documentation for verbs:  defined set of morphological classes.


### verbs: compounds

Three columns:

    CompoundEntity,StemString,SimplexEntity,Tags

Note that only morphological stem information is automatically carried over.  Since tags may refer to any taxonomic category, they cannot be safely carried over.  If you want to duplicate tags from simplex to compound form, you must explicitly enter the same set of tags in the compound entry that you used in the simplex entry, and it will be applied to *all* compound stem forms.  If you want to tag individual stems, you will have to make individual entries for them in the main/simple verb lexicon.


### substantives

### other

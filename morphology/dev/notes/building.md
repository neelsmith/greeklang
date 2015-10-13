## Building a morphological parser

The `morphology` subproject of `greeklang` does not present a precompiled "Greek" parser: its tools instead allow you to work with specific parsers built for specific corpora.  In the spirit of the HMT project, you can have as many morphologies for as many corpora as you want.

The first step then is to build a parser for your corpus.  You do this by:

1. putting one or more lexicon files with the vocabulary for your corpus into a specified directory.  (The lexicon has a simple tabular format illustrated below and fully documented elsewhere.)
2. registering abbreviations for CITE Collections used in your lexicon files in a URN registry (also illusatrated below, and fully documented elsewhere).
3. running `gradle fst`

## Minimal example

Here is a valid, complete lexicon of morphological stems, comprised of one record, from a `.tsv` file (but tabs are not displayed here...).  

    <coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>

Its five columns record

1. A URN `<coretests.n64316_0>` (in abbreviated Collection.Object form) for this morphological stem.  (The `coretests` collection must appear in the registry of URN abbreviations.)
2. A URN `<lexent.n64316>` for the Greek lexical entity.  (The abbreviation `lexent` is predefined and automatically expanded to full URN values.)
3. The stem `<#>lu` (including a morpheme boundary marker required for verbs so augment can be correctly placed in compound forms, e.g., a stem could look like `a)na<#>lu`)
4. The part of speech of the entity `<verb>`
5. An inflectional category `<w_regular>`

Here is a valid, complete URN registry from a `.csv` file that makes all vocabulary in the `coretests` collection accessible to the parser:

    coretests,urn:cite:morph:coretests,"Lexicon of stems used in testing core morphological engine"

Its three columns record

1. Collection identifier used as an abbreviated reference in lexica of morphological stems.
2. Valid collection-level CITE URN for the collection.
3. Human-readable label identifying the collection.


## Integrating a dynamically built parser into  workflows

This architecture makes it straightforward to integrate a dynamically built parser into a variety of workflows such as the HMT project's MOM validation system.

A project could

- maintain a set of tabular files with lexica of stems in a shared version control repository
- automatically incorporate those files in the build task compiling a corpus-specific parser
- apply the freshly compiled parser to a set of tokens to analyze

## Testing the core system

 `gradle fst` compiles a Finite State Transducer (FST) in a file named `greek.a`.  This FST in fact is constructed from a large hierarchy of chained transducers.  

 To test this effectively, several unit tests loop through lists transducers, and apply tests on the same sets of test data at every step of the chain.  For example, to test a single aorist indicative active form ἔλυσα, the unit test executes this sequence:

 1. first, it tests a transducer specifically handling forms requiring automatic generation of the third principal part of omega verbs
 2. next, it tests the integration of those results in a transducer handling all principal parts of omega verbs
 3. then it tests the integration of *those* results in a transducer handling all conjugated forms of all verbs
 4. then it tests the integration of those results in a transducer checking the validity of forms for all parts of speech
 5. next it tests the integration of those results in a transducer verifying that the analyzed form appears in the specific lexicon of stems this parser is built for
 6. finally, top-level tests then verify that corresponding string values (an ASCII-only set of tokens and GreekString objects from the greeklang library) result in the same analyses.

Running `gradle test` automatically compiles the FST and a suite of FST utilities.  A single gradle unit test using the FSTs might actually test a list of dozens of forms against as many as seven transducers in the chain.  This makes it easy to identify exactly where in the analysis chain an error occurs.

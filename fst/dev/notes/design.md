
# Design notes

## definitions and requirements


- goal is a two-way mapping between a surface form and a morphological analysis
    - explicitly *not* attempting to create a system modelling either synchronic or diachronic linguistic features:  the internal system is a purely utilitarian black box supporting the goal of 2-way mapping
    - NB:  this is in general a good match to FST technology, but movable Greek accents are awkward
- rigorously specified formats for both surface forms and analyses
- clean separation of concerns:  system is *only* a morphological system
- all citable conceptual entities identified by URN
    - this enables integration in larger systems
- must support dynamically loaded lexica of stems and inflectional rules
- must support dynamically defined tagging of arbitrary (even non-morphological) taxonomies


## Terminology and citable entities

Conceptually (generically), for each canonically citable *token* in a *corpus of texts*, each *morphological analysis* joins a canonically citable *stem* with a canonically citable *morphological identification* with  optionally including further *taxonomic tags*.  A given project may define canonical citation values for taxonomic tags;  it may  also define canonical citation values for each morphological analysis for each canonically citable token.

Concretely, the morphological analyzer takes a String value for a token and generates

- the URN for a stem (e.g., URN for λυ)
    - the data structure for stems in turn includes a URN for the lexical entity that the stem belongs to (e.g., URN for entity with lemma λύω)
- the URN for an identification (e.g., "1st s. pres. indic. act of a conjugated verb")
- a (possibly empty) set of project-specific taxonomic tag (examples: "epic form", "HMT project")

The analyzer is rigorously limited to working with the morphology of a String value tokens
Applying the morphological analyzer a specific text corpus therefore requires an external or wrapper system that tokenizes the corpus of texts, submits them to the analyzer and keeps track of URNs for the tokens it submits.  

This is a non-morphological concern that should be separated cleanly from the analysis system.


## Two-tier identifications

Abstractly, the system resolves a form of a lexical entity to an identification.

Concretely, in joining stems to inflectional patterns, it needs to identify (by URN) the specific stem and the specific inflectional pattern.  The stem points to a lexical entity; the identification points to a morphological ID.  I don't think we need to add URNs to individual word formations because in a corpus-oriented approach, we already know:

1. CTS URN of the occurrence, when we have a string to analyze.  (By whatever process the supplying system uses to get to a normalized form that is legit to submit to the FST.)
2. From the URN-labelled stem -> the lex.ent. URN.
3. From the infectional component, we're guaranteed to have enough data to identify the proper MorphAnalysis URN.

So we can always say "This concrete passage is form X of lexent. Y."

We break out the components of the morphId object into symbols for the FST so it can work with them directly.


## Bigger overview

This project assumes a corpus-linguistic approach to the study of historical languages.

For morphological purposes, what is the "Greek" language in this perspective?  We need to distinguish the notion of "Greek" as a historical phenomenon -- a language spoken and used by particular people in particular times and places from "Greek" as the object of scholarly study.  For the latter purpose, we can consider "Greek" to be the corpus of material that satisfies some definition of Greekness.  For morphological purposes, we can say that "Greek" is the language known from the corpus of texts that can be analyzed morphologically with the set of categories defined here.

This system is really a parser-generator:  it compiles a binary parser with a given set of stem lexica and inflectional rules.

There is no standard lexicon:  that is a corpus-focused question.

There is a minimal set of inflectional rules compiled in `inflection.a` (from `src/inflection.fst`, which in turn is simply a transducer including the rules in `src/inflection`) compiled as separate transducers.

The reason for the distinction is that there are fundamental complex inflectional patterns that persist across

## Testing

### Test JVM classes

- tested using JUnit 4 for unit tests

### Testing FST system


- all transducers are individually compiled and unit tested
- similarly, "piplelines" of transducers are  compiled and tested for integration



### Testing data contents of a complete FST for morphology

1. Compile your `morphology.a` transducer
2. Place wordlists in `testdata/wordlists`
3. Run gradle task



## extratags

Data:

- 2 directories of dynamically loaded files:  one defining stems, and one implementing inflectional rules.  The directories should be configurable
- single list of additional tags

Process:

- automatically extract list of URNs from stems
- every lexicon should be identified by some user-defined stem, e.g., &lt;ml> for middle Liddell.  Enforce this by requiring *some* extratag to be included in lex stem
- *best practice recommendation*:  any additional inflectional patterns should also be tagged.  Not explicitly enforced, however.
- Need to map morpheus stem classes/tenses (inflectionl patterns) to Smyth references
- acceptors allow optional inclusion of additional tags



## verb pipeline


### princ.parts

- first step in verb pipeline
- filter on #classtem# tag:  group into $regular$ $irregular$ princ part groups, with separate transducers for each of regular formation patterns:
    - w_regular
    - [aeo]_contract
    - (other classes to be investigated regular -mi verbs, [aio]zw)
- other classtems must give all principal parts, normally 6, or possibly 4 for deponents.  Note that deponency is not a morphological feature: absence of principal parts is just a question of usage/attestation that might reflect in some cases the semantic and syntactic phenomenon of deponency.  A single transducer should simply classify 1st-6thpp stems and use thoses values.


### augment

- follows princ. parts in verb pipeline
- mark location in lexicon, eg. <aug>lu<verb>
- classify tense/mood combos as "augmented" "unaugmented"
- define transforamtion of <aug> -> e with appropriate neighboring modifications:
    - add breathing if initial
    - drop preceding vowel
    - compound!

## accent

Data:

- explicitly characterize nominal stems with one of 3 tags `<ultacc><penacc><antacc>`
- quarrying from morpheus: it looks like default nominal entries are &lt;antacc> ("as good as recessive"), with morpheus labels `stem_acc` and `suff_acc` identifying `<penacc>` and `<ult_acc>` respectively

Process:

- gradle build takes list of words (configurable: default `wordlist.txt`), cps to buidl area
- strip accent, write list of stripped words to build area
- run FST on stripped list
- parse FST output:
    - record FST failures
    - from analysis, add accent to stripped form, cf to source string

## lexicon

- map lexicon entries to URN values in .csv file in extracting entries from morpheus source
- use .csv white boards to check off progress
- use HMT project vocab lists to drive development of inflectional patterns for real corpora:
   - *Iliad*
   - scholia
   - other texts


## unifying and integrating data

- URNs for lexical entities drawn from external lex.ent. source
- generate URNs for stems, with one collection per "lexicon".  Since each lexicon has a lex.ent. URN, we have mapped stems to lexical entities.
- generate URNs for inflectional patterns:  at what level is collection and object?  Might be sensible to include URN per transducer and output that along with stem class.  Or is stem class enough?
- do we need URNs for each fundamental analysis pattern (without tags)? e.g., each PNTMV combo for conjugated verbs?
- could we put smyth references on transducers as optional tags?
- consider library support for RDF output


## development sequence

1. harness for multiple kinds of tests, as described above
2. infinitives. Complete development of separate stem generator
3. complete conjugated forms of Smyth #308
4. compound verbs
5. ptcpls
6. adjs: regular formation of comp, superl
7. advs: degree
8. nouns: use Iliadic word lists to select first declensional classes to implement

---
layout: page
title: Dynamically supplied dictionaries of lexical entities
---

Options: `.csv` format, or directly compose `.fst` lexica

Requirements:

- must use valid alphabet of characters
- must identify lexical entity with a configured CITE Collection
- must identify a valid inflectional class


Configuration of dictionary collections


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

Lexical entries for nouns and adjectives differ only in that the stem records gender for nouns.

Nouns:

    StemURN,LexicalEntityUrn,String,Gender,InflectionClass,PersistentAcc

Adjective or pronoun:

    StemURN,LexicalEntityUrn,String,InflectionClass,PersistentAcc


Note that when analyzed, pronouns and nouns are analyzed identically (GCN); adjectives differ in having degree as well.

Nouns must include:

- URN for stem
- URN for lexical entity
- stem
- gender
- an inflectional class (see full list elsewhere)
- symbol for persistent accent. Logic is determined from *longest form*.  Example: μήνις  with gen. μήνιος .  Stem, penult.



Optionally include lexicon- or project-specific tags expressed with FST tokens.


### other

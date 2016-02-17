---
title: "Overview of the system's design"
layout: page
---

## What it is

Kanōnes is a system for building Greek morphological parsers.  It compiles a finite state transducer (FST) from a lexicon of stems and a set of inflectional patterns, both easily defined in tables read from simple `.csv` files.

Greek morphology cannot be fully analyzed with a FST, however, due to the interdependencies of morphology and movable accent, so the FST strips accents, and reports all possible analyses for the remaining string, ignoring distinctions identifiable from accent.  To implement a full parser, a `GreekParser` implementation can implement accentuation

the output of the FST can be

Stems and inflectional patterns may follow any orthographic system implemented with the `GreekOrthography`.

But fst parser works on unaccented forms.  Approach here is to use a FST on the unaccented form, algorithmically add accent, and test resulting accented form against submitted form to analyze.

Dynamically unites two data sets:

- lexicon of stems
- inflectional patterns

Joined by [inflectional class](../inflection).

Implementation here produces a finite state transducer for Greek morphology, built with the [Stuttgart FST toolbox](http://www.cis.uni-muenchen.de/~schmid/tools/SFST/).


### Design requirements for FST


- supports dynamically loaded sets of endings easily specified in text files
- supports dynamically loaded sets of inflectional rules (relatively) easily specified in text files
- explicitly enforced case-insensitive ASCII representation of polytonic Greek

### Verifying analysis by synthesis

The FST is one (central) component of a larger, comprehensive analytical system.  The FST works on forms stripped of accents.  It can generate analyses very efficiently even on extremely large sets of input data.  To verify that a given analysis is correct, the build system can algorithmically add to the stripped string the accent appropriate for a given analysis, and compare this with the intially submitted form.




## Role of orthographic system

System works on lexical tokens in a rigorously specified orthographic system.

Separation of concerns bewteen tokenizing and parsing.

Tokenizing phase must normalize accentuation.

### Normalized accentuation

- Only one accent per word token.
- No grave accents.


Make explicit how enclitics are handled.  See issue #200 in gh repo.



### Handling accent in analysis by synthesis

Irregular and indeclinable forms are record *with* accent.  By definition, these cannot be added algorithmically.

*Irregular* forms record the accented form in the inflectional pattern.

*Indeclinable tokens* recrod the nomarlized accented form in the stem pattern.

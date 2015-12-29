---
title: "Overview of the system's design"
layout: page
---

## What it is

A system for building binary parsers.


## Role of FST in analysis-by-synthesis design

Greek morphology cannot be analyzed with FST due to interaction of multiple systems: accent and morphology, accent and syllabification.  These require awareness of state that cannot be reduced to a pipeline of transformations.

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

---
title: Kanōnes, a system for building Greek morphological parsers
layout: page
---


## Features


- **Corpus specific**:  lexical stems and inflectional patterns can be easily tailored to analyze a specific corpus of texts
- **Citable**: analyses identify the lexical entity and morphological analysis with URNs, and include URNs identifying the specific stem and inflectional rule used to arrive at an analysis
- **Requires no coding**:  build a parser specific to your corpus by editing tables of stems and inflectional patterns stored in simple `.csv` files
- **Cleanly separated from *and* designed for integration with other systems**: structured output in JSON and RDF formats

## Current status

In active development.  Follow the [scorecard of paradigms from Smyth's *Greek Grammar*](smyth)!



## Release information

Initial 1.0 release expected in May, 2016.

- requires:
    - java version >= 7
    - Stuttgart Finite State Transducer tools (<http://www.cis.uni-muenchen.de/~schmid/tools/SFST/>)



- [release notes](releases)
- documentation
- github:  subproject of the [`greeklang` repository](https://github.com/neelsmith/greeklang)


## To be added with 1.0 release

- live specifications
- API docs
- maven identifiers

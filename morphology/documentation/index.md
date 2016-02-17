---
title: "Kanōnes: documentation"
layout: page
---



- Overvew: [what the system is, how it works](overview)
- [Compiling and testing a parser](building)
- Build your own parser
    - Fixed data set: [morphological forms](forms). Don't touch these.
    - per orthography:  define an alphabet in `fst`
    - [inflectional classes](inflection): these unite rules and stems.  You shouldn't need to invent new ones, but you could.
    - [Sets of inflectional rules](rules): make `csv` tabulations for 8 "part of speech" stem categories
    - [Dictionaries of lexical entities](dictionaries):  make `csv` tabulations for "part of speech" stem categories
    - URN registry. Defines collections for inflectional rules and for stem lexica.
    - TAG SYSTEM?
- Implementing a parser for your own orthography
    - Implement the `GreekParser` interface, using an implementation of the `GreekOrthography` interface
- Sample data sets included
    - LSJ quarried data in Greek orthography
    - Some data in Attic orthography
    - The HMT project rule set for Homeric epic

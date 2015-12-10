# Mapping the Attic writing system to digital code points

## Background

The current Unicode specification does not recognize any orthographic systems for writing ancient Greek other than the Ionic alphabet that first became universally used in the Hellenistic period, and developed in medieval manuscripts into the cursive form that is the basis for the orthography of modern print editions. In order to use Unicode to represent Greek texts recorded in any of the epichoric alphabets used before the Hellenic period, it is therefore necessary to define a mapping of the alphabet onto Unicode code points.

## Encoding the Attic alphabet

Until the archonship of Euclid in 403 BCE, official Athenian inscriptions are regularly written in a distinct Attic alphabet.  This specification maps the characters of the archaic and classical Attic alphabet on to Unicode code points.

The `AtticString` class implements the `GreekOrthography` interface (in the `edu.holycross.shot.orthography` package).  This interface provides methods for representing a string of Greek text either in an ASCII-only mapping that is well suited to many kinds of machine processing, or a mapping including characters in the Greek range of Unicode that looks more familiar to human readers.

The characters to be encoded are:


- characters directly transcribing characters in the Attic writing system, namely:
    - twenty-one alphabetic characters (sixteen consonants and five vowels)
    - four punctuation characters
- editorial characters commonly used to disambiguate aspects of the
    - accent characters
    - quantity


## Output specifications

## Input specifications

It is possible to create an `AtticString` object



- ASCII-only transcription maps one notional character to a single ASCII character.  Can be used for either input or output.
- In addition to transcription of characters on stone, permits analytical characters for:
    - accents
    - vowel quantity
    - initial smooth breathing
- Transcription in Greek range of Unicode.
    - individual combining characters or Unicode-equivalent precombined (FORM ?)
    - except for combinations of perispomenon with Ε or Ο.  Combining perispomenon (decimal 834 \u342)
- currently covers alphabetic texts, not yet numbers
- case-insensitive
- ordered and sortable

## Inputs

- ASCII, Unicode upper or lower case


## Outputs

- normalized Unicode form C in all cases
- ASCII all upper
- Unicode all lower


@openex@

## Constructors

ASCII form <strong concordion:set="#noacc">BOLES</strong>.  Make an AtticString, and express in unicode, you get <strong concordion:assertEquals="asUnicode(#noacc)">βολες</strong>

Allow convenience input forms of ê and ô ?




@closeex@

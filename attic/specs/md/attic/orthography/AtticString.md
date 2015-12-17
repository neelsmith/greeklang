# Representing strings of characters



Treatment of sigma

output principle

In version @version@, we recognize:

16 cons + 5 vowels
punct (4?)


3 acc
2 quant
1 elision


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

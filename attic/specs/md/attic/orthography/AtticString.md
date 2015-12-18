# Representing strings of characters


## ASCII
Editorial characters

The characters to be encoded are:

- editorial characters commonly used to disambiguate aspects of the
    - accent characters
    - quantity
    
3 acc
2 quant
1 elision

White space characters



Can roundtrip without loss

As input convenience: accept LC equivalents.  Unambiguous mapping.









## Greek Unicode


Always normalized FORM

- Treatment of sigma context dependent
- Vowel + acc -> combined



output principles unambiguous

As input convenience: accept LC equivalents.  Unambiguous mapping.








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

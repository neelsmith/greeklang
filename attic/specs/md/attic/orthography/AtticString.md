# Strings of characters


Current version of specification: @specversion@


- implements `GreekOrthography` interface
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


## Planned additions

Acrophonic numerals

# Representing strings of characters


## ASCII
In addition the characters (AtticCharacters.html),


### White space

- tab dec 9
- LF 10
- form feed 12
- CR 13
- space 32



### Editorial characters

The characters to be encoded are:

- editorial characters commonly used to disambiguate aspects of the
    - accent characters
    - quantity

3 acc
2 quant
1 elision












## Greek Unicode


Always normalized FORM NFKC

- Treatment of sigma context dependent
- Vowel + acc -> combined

- except for combinations of perispomenon with Ε or Ο.  Combining perispomenon (decimal 834 \u342)

output principles unambiguous

As input convenience: accept LC equivalents.  Unambiguous mapping.




## Constructing characters (input specifications)

It is possible to create an `AtticString` object


- Transcription in Greek range of Unicode.
    - individual combining characters or Unicode-equivalent precombined (FORM ?)



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

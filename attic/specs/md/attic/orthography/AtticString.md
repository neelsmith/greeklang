# Representing strings of characters



## Editorial characters

In addition to transcribing the alphabetic and punctuation characters used in Attic inscriptions (specified [here](AtticCharacters.html)), editions of Attic inscriptions conventionally include additional characters helping to disambiguate:

- tokenization of text in *scriptio continua*
- interpretation of vowel quantity
- interpretation of accent





### Tokenization

Archaic and classical Attic inscriptions do not normally indicate word divisions.  Any of the following white-space characters may be included in a string of Attic Greek to indicate breaks between tokens.


<table concordion:execute="#result = isValidCP(#src)">

<tr>
  <th>Tokenizing character</th>
   <th concordion:set="#src">Code point (decimal)</th>
  <th concordion:assertEquals="#result">Is valid character</th>
</tr>

<tr><td>Space</td><td>32</td><td>true</td></tr>
<tr><td>Tab</td><td>9</td><td>true</td></tr>
<tr><td>Line feed</td><td>10</td><td>true</td></tr>
<tr><td>Form feed</td><td>12</td><td>true</td></tr>
<tr><td>Carriage return</td><td>13</td><td>true</td></tr>
</table>

In addition, the apostrophe character (decimal 39) may be used to indicate elision at the end of a word token.

@openex@

### Examples of tokenizing characters

The string
<strong concordion:set="#src">EDOXSEN TEI BOLEI</strong> includes white space tokenizing the text.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong>.

The string
<strong concordion:set="#elide">TAUTA D'ENAI</strong> uses both white space and an elision character to tokenize text. It is <strong concordion:assertTrue="isValidString(#elide)">a valid Attic string</strong>.

Note semantics of CR/NL  like XML.
Physical lines of text need to be handled otherwise (outside the alphabet).

@closeex@


### Vowel quantity



2 quant



### Accents


#### ASCII mapping
3 acc


#### Unicode mapping












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

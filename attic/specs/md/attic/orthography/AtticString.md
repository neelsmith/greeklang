# Representing strings of characters

[$PROFILE$]: extended

## Editorial characters

In addition to transcribing the alphabetic and punctuation characters used in Attic inscriptions (specified [here](AtticCharacters.html)), editions of Attic inscriptions conventionally include additional characters helping to disambiguate:

- tokenization of text in *scriptio continua*
- interpretation of vowel quantity
- interpretation of accent





### Tokenizing characters

Archaic and classical Attic inscriptions do not normally indicate word divisions.  Any of the following white-space characters may be included in a string of Attic Greek in either ASCII or Greek Unicode ranges to indicate breaks between tokens.


<table concordion:execute="#result = isValidCP(#src)">

<tr>
  <th>Tokenizing character</th>
   <th concordion:set="#src">Code point (decimal)</th>
  <th concordion:assertEquals="#result">Valid character?</th>
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
<strong concordion:set="#src">EDOXSEN TEI BOLEI</strong> includes white space tokenizing the text.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.

The string
<strong concordion:set="#src">εδοχσεν τει βολει</strong> includes white space tokenizing the text.  It is <strong concordion:assertTrue="isValidUString(#src)">a valid Attic string</strong> in the Greek range of Unicode.



The string
<strong concordion:set="#elide">TAUTA D'ENAI</strong> uses both white space and an elision character to tokenize text. It is <strong concordion:assertTrue="isValidString(#elide)">a valid Attic string</strong>.


The string
<strong concordion:set="#elide">ταυτα δ'εναι</strong> uses both white space and an elision character to tokenize text. It is <strong concordion:assertTrue="isValidUString(#elide)">a valid Attic string</strong> in the Greek range of Unicode.


@closeex@

Note in particular the semantics of codepoints 10, 12 and 13: they tokenize a string, exactly like the space or tab character.  They do *not* indicate anything about the structure of physical lines of a  text.


### Vowel quantity

Each of the five vowels in the Attic alphabet A, E, I, O, U could stand for a short or long quantity.  The vowels E and O could in addition stand for diphthongs resulting from assimilation to a following vowel.



The following characters may be included in a string of Attic Greek to mark vowel quantity.


<table concordion:execute="#result = isValidCP(#src)">

<tr>
  <th>Character</th>
   <th concordion:set="#src">Code point (decimal)</th>
  <th concordion:assertEquals="#result">Valid character?</th>
</tr>

<tr><td>Underscore</td><td>95</td><td>true</td></tr>
<tr><td>Caret</td><td>94</td><td>true</td></tr>

</table>

A string of Attic Greek in either ASCII or Greek Unicode ranges may include an underscore character following a vowel to mark it explicitly as having a long value.  In the case of E or O, the underscore marks a vowel that is either long by nature or a diphthong.  A string of Attic Greek in either ASCII or Greek Unicode ranges may include a caret  following a vowel to mark it explicitly as having a short value.



@openex@
### Examples


The string
<strong concordion:set="#src">BO_LE_I</strong> includes explicit indications that the O and E vowels have long values.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.

The string
<strong concordion:set="#src">βο_λε_ι</strong> includes explicit indications that the O and E vowels have long values.  It is <strong concordion:assertTrue="isValidUString(#src)">a valid Attic string</strong> in the Greek range of Unicode.

The string
<strong concordion:set="#src">NI^KE</strong> explicitly marks the iota as having a short value.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.


The string
<strong concordion:set="#src">νι^κε</strong> explicitly marks the iota as having a short value.  It is <strong concordion:assertTrue="isValidUString(#src)">a valid Attic string</strong> in the Greek range of Unicode.


@closeex@


### Accents

The mapping of Attic strings for the ASCII range and the Greek range of Unicode have distinct conventions for editorial addition of accents.

#### ASCII mapping

The three accents, circumflex, acute, and grave, are mapped to ASCII characters as follows:



<table concordion:execute="#result = isValidString(#src)">

<tr>
  <th>Character</th>
   <th concordion:set="#src">Character</th>
   <th>Code point (decimal)</th>
  <th concordion:assertEquals="#result">Valid character?</th>
</tr>

<tr><td>Circumflex</td><td>=</td><td>61</td><td>true</td></tr>
<tr><td>Acute</td><td>/</td><td>47</td><td>true</td></tr>
<tr><td>Grave</td><td>\</td><td>92</td><td>true</td></tr>

</table>

The accent character must *follow* either the vowel character it accents, or the vowel quantity character identifying the quantity of the preceding vowel character.



@openex@
### Examples

The string
<strong concordion:set="#src">BOLE/</strong> includes oxytone accent.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.


The string
<strong concordion:set="#src">BOLE=S</strong> includes perispomenon accent.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.


The string
<strong concordion:set="#src">BO_LE_/</strong> includes oxytone accent as well as explicit indications that the O and E vowels have long values.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.



The string
<strong concordion:set="#src">BO_LE_=S</strong> includes perispomenon accent as well as explicit indications that the O and E vowels have long values.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.


@closeex@


#### Unicode mapping




## Summary of valid characters

Attic strings are composed exclusively of  alphabetic and punctuation characters, as specified [here](AtticCharacters.html), tokenizing characters, characters indicating vowel quantity, and characters indicating accent, as specified above.  This [table](AsciiSummary.html) summarizes all valid characters used in the ASCII mapping.


## Creating valid strings



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

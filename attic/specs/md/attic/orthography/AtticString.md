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
### Examples of quantity markers


The string
<strong concordion:set="#src">BO_LE_I</strong> includes explicit indications that the O and E vowels have long values.  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.

The string
<strong concordion:set="#src">βο_λε_ι</strong> includes explicit indications that the O and E vowels have long values.  It is <strong concordion:assertTrue="isValidUString(#src)">a valid Attic string</strong> in the Greek range of Unicode.


The string
<strong concordion:set="#src">HO_TO^S</strong> explicitly marks the first 0 as long, and the second O as short (e.g., as the masculine nominative singular pronoun written in the Ionic literary alphabet οὗτος).  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.

The string
<strong concordion:set="#src">HO_TO_S</strong> explicitly marks both O characters as long (e.g., as the adverb written in the Ionic literary alphabet οὕτως).  It is <strong concordion:assertTrue="isValidString(#src)">a valid Attic string</strong> in the ASCII mapping.

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
### Examples of accents in the ASCII mapping

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


Since all strings are represented in Unicode form NFKC, combinations of accents and vowels are represented by the precomposed form, where one exists, for the combination of one of the specified [lower case vowels](AtticCharacters.html) with the combining accent character (combining acute codepoint 301, combining acute accent codepoint 300, or combining perispomenon codepoint x342), possibly with a combining form of either the smooth breathing (codepoint x313, combining turned comma above) or rough breathing (codepoint x314, combining comma above) characters.  Since there is no precombined form of epsilon or omicron with circumflex in the Ionic alphabet, when the Attic vowel E or O is mapped to epsilon or omicron, circumflex accents are indicated by following the vowel with codepoint x342, the combining perispomenon.



@openex@

### Examples of accents in the Greek range of Unicode

@closeex@







## Summary of valid characters

Attic strings are composed exclusively of  alphabetic and punctuation characters, as specified [here](AtticCharacters.html), tokenizing characters, characters indicating vowel quantity, and characters indicating accent, as specified above.  This [table](AsciiSummary.html) summarizes all valid characters used in the ASCII mapping.

For a full list of the form NFKC Unicode characters used to map Attic strings to the Greek range of Unicode, please see, in addition to the
 [specified alphabetic and punctuations](AtticCharacters.html), and the tables above, the  Unicode consortium's normalization chart for Greek: <http://www.unicode.org/charts/normalization/>.

## Creating valid strings

The specified representation of Attic strings mapped either to ASCII characters only or to the Greek range of Unicode allows for unambiguous [comparison and sorting of Attic strings](AtticSort.html).  It is convent to support the following equivalent forms of input when creating an Attic string:

- ASCII mappings accept the lower-case equivalent of alphabetic characters
- Greek unicode mappings accept the upper-case equivalent of alphabetic characters
- Greek unicode mappings accept equivalent decomposed forms of vowels with breathing, accents or both




@openex@

### Examples of constructing Attic strings

The string <strong concordion:set="#src">DEMOS</strong> is a <strong concordion:assertTrue="isValidString(#src)">valid input form</strong> to create an Attic string in the ASCII mapping.

The string <strong concordion:set="#src">δεμος</strong> is a <strong concordion:assertTrue="isValidUString(#src)">valid input form</strong> to create an Attic string in the mapping to the Greek range of Unicode.

The string <strong concordion:set="#src">Demos</strong> is a <strong concordion:assertTrue="isValidString(#src)">valid input form</strong> to create an Attic string in the ASCII mapping.

The string <strong concordion:set="#src">Δεμος</strong> is a <strong concordion:assertTrue="isValidUString(#src)">valid input form</strong> to create an Attic string in the mapping to the Greek range of Unicode.


The string <strong concordion:set="#src">demos</strong> is a <strong concordion:assertTrue="isValidString(#src)">valid input form</strong> to create an Attic string in the ASCII mapping..

The string <strong concordion:set="#src">ΔΕΜΟΣ</strong> is a <strong concordion:assertTrue="isValidUString(#src)">valid input form</strong> to create an Attic string in the mapping to the Greek range of Unicode.


@closeex@

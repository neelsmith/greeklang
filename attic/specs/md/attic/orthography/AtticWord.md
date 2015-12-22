# Word tokens



## Tokenization



A string of Attic Greek can be split into *lexical tokens* composed of one or more alphabetic characters, editorial characters and the elision character, but excluding punctuation and tokenizing white space. These are equivalent to splitting the string on the [specified tokenizing characters](AtticString.html), and removing all specified punctuation characters.

@openeex@

### Examples:  tokenization

The string <strong concordion:set="#src">EDOXSEN TEI BOLEI</strong> includes tokenizing white space.  We can tokenize this string into:

<table concordion:verifyRows="#token : tokenize(#src)">
       <tr><th concordion:assertEquals="#token">Token</th></tr>
<tr><td>EDOXSEN</td></tr>
<tr><td>TEI</td></tr>
<tr><td>BOLEI</td></tr>
</table>


The string <strong concordion:set="#src">TAUTA D'ENAI</strong> includes a white space and an elision marker.  We can tokenize this into:

<table concordion:verifyRows="#token : tokenize(#src)">
       <tr><th concordion:assertEquals="#token">Token</th></tr>
<tr><td>TAUTA</td></tr>
<tr><td>D'</td></tr>
<tr><td>ENAI</td></tr>
</table>


The string <strong concordion:set="#src">TAUTA:D'ENAI</strong> includes a punctuation mark and an elision marker.  We can tokenize this identically to the preceding example:

<table concordion:verifyRows="#token : tokenize(#src)">
       <tr><th concordion:assertEquals="#token">Token</th></tr>
<tr><td>TAUTA</td></tr>
<tr><td>D'</td></tr>
<tr><td>ENAI</td></tr>
</table>


@closeex@

## Syllabification

Word tokens can be split into ordered sets of syllables where each syllable is a valid, non-empty Greek string.

## Accentuation

Accent characters can be automatically added to word tokens in cases where a recessive or persistent accent patterns persistent accent pattern does not require further morphological information, and vowel quantity is explicitly indicated.

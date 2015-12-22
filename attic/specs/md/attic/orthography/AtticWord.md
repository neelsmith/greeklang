# Word tokens



## Lexical tokenization

A string of Attic Greek can be split into *lexical tokens* composed of one or more alphabetic characters, editorial characters and the elision character, but excluding punctuation and tokenizing white space. These are equivalent to splitting the string on the [specified tokenizing characters](AtticString.html), and removing all specified punctuation characters.  These tokens are suitable for morphological analysis.

@openex@

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

Lexical tokens can be split into ordered sets of syllables where each syllable is a valid, non-empty Greek string.


@openex@

### Examples:  syllabification

The token <strong concordion:set="#src">EDOXSEN</strong> can be divided into three syllables:

<table concordion:verifyRows="#token : syllabify(#src)">
       <tr><th concordion:assertEquals="#token">Token</th></tr>
<tr><td>E</td></tr>
<tr><td>DO</td></tr>
<tr><td>XSEN</td></tr>
</table>


The token <strong concordion:set="#src">ENAI</strong> can be divided into two syllables:

<table concordion:verifyRows="#token : syllabify(#src)">
       <tr><th concordion:assertEquals="#token">Token</th></tr>
<tr><td>E</td></tr>
<tr><td>NAI</td></tr>
</table>



In the token <strong concordion:set="#src">E_NAI</strong>, the quantity marker is carried through:

<table concordion:verifyRows="#token : syllabify(#src)">
       <tr><th concordion:assertEquals="#token">Token</th></tr>
<tr><td>E_</td></tr>
<tr><td>NAI</td></tr>
</table>


@closeex@

## Accentuation

Accent characters can be automatically added to word tokens in cases where a recessive or persistent accent patterns persistent accent pattern does not require further morphological information, and vowel quantity is explicitly indicated.

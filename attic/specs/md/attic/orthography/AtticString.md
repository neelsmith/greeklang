# Mapping the Attic writing system to digital code points

## Background

The current Unicode specification does not recognize any orthographic systems for writing ancient Greek other than the Ionic alphabet that first became universally used in the Hellenistic period, and developed in medieval manuscripts into the cursive form that is the basis for the orthography of modern print editions. In order to use Unicode to represent Greek texts recorded in any of the epichoric alphabets used before the Hellenic period, it is therefore necessary to define a mapping of the alphabet onto Unicode code points.

This specification follows the logic of the `GreekOrthography` interface (in the `edu.holycross.shot.orthography` package): it defines a representation in an ASCII-only mapping that is well suited to many kinds of machine processing, and a mapping including characters in the Greek range of Unicode with glyphs that are more familiar to human readers.

## Encoding the Attic alphabet

Until the archonship of Euclid in 403 BCE, official Athenian inscriptions are regularly written with <strong concordion:assertEquals="countAlphas()">21</strong>, case-insensitive alphabetic characters.  Twenty of them corresponding to characters in the Ionic alphabet are mapped to Unicode characters as specified in the following table:

<table concordion:execute="#result = asciiForU(#src)">

<tr>
  <th>Correspondence in Ionic literary orthography </th>
   <th concordion:set="#src">Typical visual display</th>
  <th concordion:assertEquals="#result">ASCII representation</th>
</tr>
<tr><td>alpha (long or short vowel)</td><td>α</td><td>A</td></tr>
<tr><td>beta</td><td>β</td><td>B</td></tr>
<tr><td>gamma</td><td>γ</td><td>G</td></tr>
<tr><td>delta</td><td>δ</td><td>D</td></tr>
<tr><td>short epsilon, long eta, or diphthong ei</td><td>ε</td><td>E</td></tr>
<tr><td>zeta</td><td>ζ</td><td>Z</td></tr>
<tr><td>theta</td><td>θ</td><td>Q</td></tr>
<tr><td>iota (long or short vowel)</td><td>ι</td><td>I</td></tr>
<tr><td>kappa</td><td>κ</td><td>K</td></tr>
<tr><td>lamda</td><td>λ</td><td>L</td></tr>
<tr><td>mu</td><td>μ</td><td>M</td></tr>
<tr><td>nu</td><td>ν</td><td>N</td></tr>
<tr><td>short omicron, long omega, or diphthong ou</td><td>ο</td><td>O</td></tr>
<tr><td>pi</td><td>π</td><td>P</td></tr>
<tr><td>rho</td><td>ρ</td><td>R</td></tr>
<tr><td>sigma</td><td>σ</td><td>S</td></tr>
<tr><td>tau</td><td>τ</td><td>T</td></tr>
<tr><td>upsilon (long or short vowel)</td><td>υ</td><td>U</td></tr>
<tr><td>fi</td><td>φ</td><td>F</td></tr>
<tr><td>chi</td><td>χ</td><td>X</td></tr>
</table>




<table concordion:execute="#result = uForAscii(#src)">

<tr>
  <th>Correspondence in Ionic literary orthography </th>
  <th concordion:assertEquals="#result">ASCII representation</th>
   <th concordion:set="#src">Typical visual display</th>

</tr>
<tr><td>alpha (long or short vowel)</td><td>α</td><td>A</td></tr>
<tr><td>beta</td><td>β</td><td>B</td></tr>
<tr><td>gamma</td><td>γ</td><td>G</td></tr>
<tr><td>delta</td><td>δ</td><td>D</td></tr>
<tr><td>short epsilon, long eta, or diphthong ei</td><td>ε</td><td>E</td></tr>
<tr><td>zeta</td><td>ζ</td><td>Z</td></tr>
<tr><td>theta</td><td>θ</td><td>Q</td></tr>
<tr><td>iota (long or short vowel)</td><td>ι</td><td>I</td></tr>
<tr><td>kappa</td><td>κ</td><td>K</td></tr>
<tr><td>lamda</td><td>λ</td><td>L</td></tr>
<tr><td>mu</td><td>μ</td><td>M</td></tr>
<tr><td>nu</td><td>ν</td><td>N</td></tr>
<tr><td>short omicron, long omega, or diphthong ou</td><td>ο</td><td>O</td></tr>
<tr><td>pi</td><td>π</td><td>P</td></tr>
<tr><td>rho</td><td>ρ</td><td>R</td></tr>
<tr><td>sigma</td><td>ς</td><td>S</td></tr>
<tr><td>tau</td><td>τ</td><td>T</td></tr>
<tr><td>upsilon (long or short vowel)</td><td>υ</td><td>U</td></tr>
<tr><td>fi</td><td>φ</td><td>F</td></tr>
<tr><td>chi</td><td>χ</td><td>X</td></tr>
</table>


In addition, the Attic alphabet has a character for the aspirate corresponding to the rough breathing mark in Ionic.  This is conventionally  transcribed with `h` in print editions of Attic inscriptions.

<table  concordion:execute="#result = getRoughBreathing()">
<tr>
  <th>Correspondence in Ionic literary orthography </th>
   <th >Typical visual display</th>
  <th concordion:assertEquals="#result">ASCII representation</th>
</tr>
<tr><td>rough breathing (aspirate)</td><td>h</td><td>H</td></tr>
</table>


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

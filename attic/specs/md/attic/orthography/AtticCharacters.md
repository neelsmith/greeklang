# Representation of the characters in the Attic writing system

This page specifies two systems for directly transcribing characters used in the Attic writing system.


## Encoding Attic characters in the ASCII range of Unicode

Until the archonship of Euclid in 403 BCE, official Athenian inscriptions are regularly written with <strong concordion:assertEquals="countAlphas()">21</strong>, case-insensitive alphabetic characters.  Twenty of them corresponding to characters in the Ionic alphabet are mapped to Unicode characters in the upper-case ASCII range as specified in the following table:

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
<tr><td>phi</td><td>φ</td><td>F</td></tr>
<tr><td>chi</td><td>χ</td><td>X</td></tr>
</table>

The Attic alphabet has a further alphabetic character for the aspirate corresponding to the rough breathing mark in Ionic.  This is conventionally  transcribed with `h` in print editions of Attic inscriptions.

<table  concordion:execute="#result = getRoughBreathing()">
<tr>
  <th>Correspondence in Ionic literary orthography </th>
   <th >Typical visual display</th>
  <th concordion:assertEquals="#result">ASCII representation</th>
</tr>
<tr><td>rough breathing (aspirate)</td><td>h</td><td>H</td></tr>
</table>

Version <strong>@specversion@</strong> of this specification recognizes <strong concordion:assertEquals="countPuncts()">2</strong> punctuation characters, mapped to the following ASCII characters:

<table concordion:execute="#result = codePoint(#src)">

<tr>
  <th>Usage </th>
   <th concordion:set="#src">ASCII representation</th>
  <th concordion:assertEquals="#result">Unicode code point (decimal)</th>
</tr>
<tr><td>A major break, or full stop; form can resemble two dots or a colon</td><td>.</td><td>46</td></tr>
<tr><td>A less significant break; form can resemble two or three vertical dots </td><td>:</td><td>58</td></tr>
</table>





## Encoding Attic characters in the Greek range of Unicode

The same twenty characters listed above are mapped to lower-case characters in the Greek range of Unicode as specified in the following table.  All values are in Unicode NFKC form.

<table concordion:execute="#result = uForAscii(#src)">

<tr>
  <th>Correspondence in Ionic literary orthography </th>
  <th concordion:assertEquals="#result">Mapping to Greek range of Unicode</th>
   <th concordion:set="#src">Mapping to ASCII</th>

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

In mapping sigma to the Greek range of Unicode, the mapping depends on context.  When sigma terminates a token as defined in the specification of [Attic Greek string values](AtticString.html), it is mapped to (lower-case) terminal sigma (codepoint 962 decimal);  otherwise is mapped to (lower-case) initial/medial sigma (codepoint 963 decimal).



@openex@

### Example

As listed above, an isolated sigma is represented by <strong concordion:set="#terminal">S</strong> in the ASCII mapping, and terminal form of sigma <strong concordion:assertEquals="uForAscii(#terminal)">ς</strong> in the Unicode mapping.  By contrast, the cluster sigma+tau is represented by the ASCII mapping <strong concordion:set="#medial">ST</strong> and the Unicode mapping <strong concordion:assertEquals="uForAscii(#medial)">στ</strong>.

See further examples in the specification for [Attic Greek string values](AtticString.html).
@closeex@


The two punctuation marks supported in version **@specversion@** are mapped to the period and the mid-dot characters as follows:

<table concordion:execute="#result = codePoint(#src)">

<tr>
  <th>Usage </th>
   <th concordion:set="#src">ASCII representation</th>
  <th concordion:assertEquals="#result">Unicode code point (decimal)</th>
</tr>
<tr><td>A major break, or full stop; form can resemble two dots or a colon</td><td>.</td><td>46</td></tr>
<tr><td>A less significant break; form can resemble two or three vertical dots </td><td>·</td><td>183</td></tr>
</table>

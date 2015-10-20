# ASCII representation of Greek strings #

The following characters are allowed in the ASCII representation of Greek strings.

## Alphabetic characters ##

To represent the Greek alphabetic characters alpha-omega, the ASCII characters of the TLG beta-code mapping are permitted in either upper- or lower-case form.  To represent upper-case Greek characters, the ASCII character is preceded by an asterisk (Unicode 42).

Iota subscript is treated as a distinct character, and is represented by the vertical bar (or "pipe", Unicode 124).  Sigma, on the other hand, is a single character:  because presentational variants such as terminal or lunate sigma are not characters, they are not represented in Greek strings.

@openex@

### Examples: lower-case characters ###

The mapping of ASCII to Unicode Greek transcriptions can be illustrated by
creating a GreekString from an ASCII source, and then converting the GreekString to Unicode in NFC form.

<table concordion:execute="#result = uForAscii(#src2)">

<tr>
   <th concordion:set="#src2">Source String</th>
  <th concordion:assertEquals="#result">GreekString as Unicode</th>
</tr>

<tr><td>a</td><td>α</td></tr>
<tr><td>b</td><td>β</td></tr>
<tr><td>g</td><td>γ</td></tr>
<tr><td>d</td><td>δ</td></tr>
<tr><td>e</td><td>ε</td></tr>
<tr><td>z</td><td>ζ</td></tr>
<tr><td>h</td><td>η</td></tr>
<tr><td>q</td><td>θ</td></tr>
<tr><td>i</td><td>ι</td></tr>
<tr><td>k</td><td>κ</td></tr>
<tr><td>l</td><td>λ</td></tr>
<tr><td>m</td><td>μ</td></tr>
<tr><td>n</td><td>ν</td></tr>
<tr><td>c</td><td>ξ</td></tr>
<tr><td>o</td><td>ο</td></tr>
<tr><td>p</td><td>π</td></tr>
<tr><td>r</td><td>ρ</td></tr>
<tr><td>s</td><td>ς</td></tr>
<tr><td>t</td><td>τ</td></tr>
<tr><td>u</td><td>υ</td></tr>
<tr><td>f</td><td>φ</td></tr>
<tr><td>x</td><td>χ</td></tr>
<tr><td>y</td><td>ψ</td></tr>
<tr><td>w</td><td>ω</td></tr>
<tr><td>|</td><td>ι</td></tr>
</table>




### Examples: iota subscript ###


<table concordion:execute="#result = uForAscii(#src2)">

<tr>
   <th concordion:set="#src2">Source String</th>
  <th concordion:assertEquals="#result">GreekString as Unicode</th>
</tr>


<tr><td>a|</td><td>ᾳ</td></tr>
<tr><td>h|</td><td>ῃ</td></tr>
<tr><td>w|</td><td>ῳ</td></tr>


</table>

### Examples: case insensitivity ###

<table concordion:execute="#result = getAsciiString(#src)">
	<tr>
	  <th concordion:set="#src">Source String</th>
	  <th concordion:assertEquals="#result">GreekString</th>
	</tr>

	<tr><td>MH=NIN</td><td>mh=nin</td></tr>
	<tr><td>mh=nin</td><td>mh=nin</td></tr>
	<tr><td>Mh=nin</td><td>mh=nin</td></tr>
	<tr><td>*mh=nin</td><td>*mh=nin</td></tr>

      </table>

<table concordion:execute="#result = uForAscii(#src)">
	<tr>
	  <th concordion:set="#src">Source String</th>
	  <th concordion:assertEquals="#result">GreekString as Unicode</th>
	</tr>

	<tr><td>MH=NIN</td><td>μῆνιν</td></tr>
	<tr><td>mh=nin</td><td>μῆνιν</td></tr>
	<tr><td>Mh=nin</td><td>μῆνιν</td></tr>
	<tr><td>*mh=nin</td><td>Μῆνιν</td></tr>

      </table>

@closeex@




## Breathings, accents and diaeresis ##

Breathings, accents and diaeresis are all treated as distinct characters.  Rough and smooth breathing are represented by opening and closing parenthesis characters, respectively (Unicode 28 and 29).  Acute, grave and circumflex accents are represented by the solidus (Unicode 47), reverse solidus (Unicode 92), and equals sign (Unicode 61), respectively.  The diaeresis is represented by the plus sign (Unicode 43).

Individual breathings, accents and diaeresis follow the vowel over which they are traditionally written.


@openex@

### Examples ###


The grave accent in <strong concordion:set="#grave">qea\\</strong> is valid.  Formatting this as a Unicode string produces <strong concordion:assertEquals="uForAscii(#grave)">θεὰ</strong>.


The acute accent in <strong concordion:set="#acute">ou)lome/nhn</strong> is valid. Formatting this as a Unicode string produces <strong concordion:assertEquals="uForAscii(#acute)">οὐλομένην</strong>.

The circumflex accent in <strong concordion:set="#circ">mh=nin</strong> is valid.  Formatting this as a Unicode string produces <strong concordion:assertEquals="uForAscii(#circ)">μῆνιν</strong>.

The diaresis character in <strong concordion:set="#diaer">basilh=i+</strong> is valid.  Formatting this as a Unicode string produces <strong concordion:assertEquals="uForAscii(#diaer)">βασιλῆϊ</strong>.

@closeex@



## White space

GreekStrings may include any of the following "white space" characters: space (Unicode 32), tab (Unicode 9), new line (Unicode 10), carriage return (Unicode 13).  They are preserved unchanged both in the underlying representation and in conversions to string values.

@openex@

### Example ###

If we intialize a GreekString from the source string <strong concordion:set="#white">*Mh=nin a)/eide</strong>, then converting it back to an ASCII string will preserve the white space:

<pre concordion:assertEquals="getAsciiString(#white)">*mh=nin a)/eide</pre>


@closeex@

## Punctuation ##

The following punctuation marks are valid


- period
- comma
- high stop
 - question mark
 - crasis

@openex@

### Examples: punctuation ###

TBA

@closeex@






## Sequences of characters ##

Adjacent breathing, accent, and diaeresis are always represented in that sequence.

The sequence breathing, accent, and diaeresis *follows* lower-case vowels.  When the vowel is a diphthong, they follow the second vowel of the diphthong. For upper-case vowels, the sequence follows the asterisk marking upper case, and *precedes* the vowel character.  While this may seem illogical, it simplifies interoperation with legacy ASCII-only encodings of polytonic Greek.


@openex@

### Examples: sequences of breathing, accent and diaeresis ###


<table concordion:execute="#result = uForAscii(#src)">
	<tr>
	  <th concordion:set="#src">Source String</th>
	  <th concordion:assertEquals="#result">GreekString as Unicode</th>
	  <th>Comment</th>
	</tr>
	<tr>
	<td>a)/eide</td>
	<td>ἄειδε</td>
<td>lower case vowel followed by a breathing, then an accent</td>
</tr>
	<tr>
	<td>ou)lome/nhn</td>
	<td>οὐλομένην</td>
			<td>diphthong: breathing following second vowel</td>
		</tr>
	<tr>
	<td>e)u+knh/mides</td>
	<td>ἐϋκνήμιδες</td>
		<td>not a diphthong (due to diaeresis), so breathing follows first vowel</td>
	</tr>



<tr>
	<td>*)axilh=os</td>
	<td>Ἀχιλῆος</td>
		<td>upper case vowel with breathing</td>
	</tr>

<tr>
	<td>*)/enq'</td>
	<td>Ἔνθʼ</td>
		<td>upper case vowel with breathing and accent</td>
	</tr>



	</table>










@closeex@

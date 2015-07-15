# Unicode subset #



## Unicode Greek mapping ##

The following characters are allowed in the transcription system using the ancient Greek section of Unicode.

### Individual alphabetic characters ###



For the twenty-four individual alphabetic characters of the Attic-Ionic alphabet, the
twenty-four upper-case Unicode code points 0391 - 03A1 and 03A3 - 03A9 may be used.  For equivalent lower-case characters, the  twenty-five lower case Unicode code points from 03B1 - 03C9 may be used.  Either 03C2 (final sigma) or 03C3 (sigma) may be used for the character sigma;  both are mapped to ASCII `s`.


@openex@

The mapping of ASCII to Unicode Greek transcriptions can be illustrated by creating a GreekString from a Unicode source, and then converting the GreekString to the corresponding ASCII-only transcription.

<table concordion:execute="#result = getBetaForUnicode(#src2)">

<tr>
	  <th concordion:assertEquals="#result">GreekString</th>
	   <th concordion:set="#src2">Source String</th>
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
<tr><td>s</td><td>σ</td></tr>
<tr><td>t</td><td>τ</td></tr>
<tr><td>u</td><td>υ</td></tr>
<tr><td>f</td><td>φ</td></tr>
<tr><td>x</td><td>χ</td></tr>
<tr><td>y</td><td>ψ</td></tr>
<tr><td>w</td><td>ω</td></tr>
</table>

@closeex@

### Iota subscript, diaeresis, vowels, accents and breathings ###



A GreekString may be individual Greek vowel characters together with the combining Unicode codepoint for smooth or rough breathing,  the three accent characters, iota subscript and diaeresis.  Alternatively, a GreekString may use the equivalent Unicode precombined characters.  Whether constructed from beta-code or unicode source string, Greek Strings can be converted to Unicode in NFC form.

@openex@

###Examples: transcription with combining and precombined codepoints


<table concordion:execute="#result = getBetaForUnicode(#src)">

<tr>
	  <th>Combining/precombined</th>
	  <th concordion:set="#src">Source String</th>
	  <th concordion:assertEquals="#result">GreekString</th>
	</tr>

<tr>
	  <td>combining</td>
	  <td>μῆνιν</td>
	  <td>mh=nin</td>
	</tr>
<tr>
	  <td>combining</td>
	  <td>Μῆνιν</td>
	  <td>*mh=nin</td>
	</tr>

<tr>
	  <td>precombined</td>
	  <td>μῆνιν</td>
	  <td>mh=nin</td>
	</tr>
	  
<tr>
	  <td>precombined</td>
	  <td>Μῆνιν</td>
	  <td>*mh=nin</td>
	</tr>
	
</table>



@closeex@





@openex@


### Examples:  conversion to NFC Unicode ###


The ASCII string <strong concordion:set="#beta1">*mh=nin</strong> converts to the NFC Unicode string <strong concordion:assertEquals="asUnicode(#beta1)">Μῆνιν</strong>.


The Unicode string <strong concordion:set="#u1">ἐπίρρημα</strong> converts to ASCII string <strong concordion:assertEquals="getBetaForUnicode(#u1)">e)pi/rrhma</strong> and NFC Unicode string 
<strong concordion:assertEquals="uForU(#u1)">ἐπίρρημα</strong>
@closeex@


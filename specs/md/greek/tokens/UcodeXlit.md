# Unicode subset #



## Unicode Greek mapping ##


A GreekString may be created from either precombined or combining Unicode codepoints.  Equivalent values in Unicode are 


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




@openex@

###Examples


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


Whether constructed from beta-code or unicode source string, Greek Strings can be converted to Unicode in NFC form.


@openex@


### Example ###


The ASCII string <strong concordion:set="#beta1">*mh=nin</strong> converts to the NFC Unicode string <strong concordion:assertEquals="asUnicode(#beta1)">Μῆνιν</strong>.


The Unicode string <strong concordion:set="#u1">ἐπίρρημα</strong> converts to ASCII string <strong concordion:assertEquals="getBetaForUnicode(#u1)">e)pi/rrhma</strong> and NFC Unicode string 
<strong concordion:assertEquals="uForU(#u1)">ἐπίρρημα</strong>
@closeex@


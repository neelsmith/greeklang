# Valid characters in MilesianStrings


MilesianStrings are composed exclusively of characters relevant for numeric notation in the "Milesian" system: 27 characters for digits representing unit values 1-9, the tens values 10-90 and the hundreds values 100-900;  a character for the value 10,000 (μυριάς); a special character representing zero or a null value (οὐδέν); two characters abbreviating the fractions 1/2 and 2/3; and three punctuation characters used to distinguish integers from fractions, and to separate units of thousands from smaller units.

MilesianStrings are created from Strings by mapping Unicode code points on to the ancient Greek characters according to one of two mappings:

- a subset of the ancient Greek range of Unicode
- Strings using only ASCII characters following convetions of the TLG project's Beta Code



## Valid digit characters ##



MilesianStrings may be constructed from the following lower-case Unicode characters to represent integers < 1,000.

**Ones digits**:


<table>
<colgroup>
<col style="text-align:left;"/>
<col style="text-align:left;"/>
<col style="text-align:left;"/>
</colgroup>

<thead>
<tr>
	<th style="text-align:left;">Numeric value</th>
	<th style="text-align:left;">Unicode code point</th>
	<th style="text-align:left;">Typical glyph</th>
</tr>
</thead>

<tbody>
<tr>
	<td style="text-align:left;">1</td>
	<td style="text-align:left;">U 03B1</td>
	<td style="text-align:left;">α</td>
</tr>
<tr>
	<td style="text-align:left;">2</td>
	<td style="text-align:left;">U 03B2</td>
	<td style="text-align:left;">β</td>
</tr>
<tr>
	<td style="text-align:left;">3</td>
	<td style="text-align:left;">U 03B3</td>
	<td style="text-align:left;">γ</td>
</tr>
<tr>
	<td style="text-align:left;">4</td>
	<td style="text-align:left;">U 03B4</td>
	<td style="text-align:left;">δ</td>
</tr>
<tr>
	<td style="text-align:left;">5</td>
	<td style="text-align:left;">U 03B5</td>
	<td style="text-align:left;">ε</td>
</tr>
<tr>
	<td style="text-align:left;">6</td>
	<td style="text-align:left;">U 3DB</td>
	<td style="text-align:left;">ϛ</td>
</tr>
<tr>
	<td style="text-align:left;">7</td>
	<td style="text-align:left;">U 03B6</td>
	<td style="text-align:left;">ζ</td>
</tr>
<tr>
	<td style="text-align:left;">8</td>
	<td style="text-align:left;">U 03B7</td>
	<td style="text-align:left;">η</td>
</tr>
<tr>
	<td style="text-align:left;">9</td>
	<td style="text-align:left;">U 03B8</td>
	<td style="text-align:left;">θ</td>
</tr>
</tbody>
</table>


**Tens digits**:


<table>
<colgroup>
<col style="text-align:left;"/>
<col style="text-align:left;"/>
<col style="text-align:left;"/>
</colgroup>

<thead>
<tr>
	<th style="text-align:left;">Numeric value</th>
	<th style="text-align:left;">Unicode code point</th>
	<th style="text-align:left;">Typical glyph</th>
</tr>
</thead>

<tbody>
<tr>
	<td style="text-align:left;">10</td>
	<td style="text-align:left;">U 03B9</td>
	<td style="text-align:left;">ι</td>
</tr>
<tr>
	<td style="text-align:left;">20</td>
	<td style="text-align:left;">U 03BA</td>
	<td style="text-align:left;">κ</td>
</tr>
<tr>
	<td style="text-align:left;">30</td>
	<td style="text-align:left;">U 03BB</td>
	<td style="text-align:left;">λ</td>
</tr>
<tr>
	<td style="text-align:left;">40</td>
	<td style="text-align:left;">U 03BC</td>
	<td style="text-align:left;">μ</td>
</tr>
<tr>
	<td style="text-align:left;">50</td>
	<td style="text-align:left;">U 03BD</td>
	<td style="text-align:left;">ν</td>
</tr>
<tr>
	<td style="text-align:left;">60</td>
	<td style="text-align:left;">U 3DE</td>
	<td style="text-align:left;">ξ</td>
</tr>
<tr>
	<td style="text-align:left;">70</td>
	<td style="text-align:left;">U 03BF</td>
	<td style="text-align:left;">ο</td>
</tr>
<tr>
	<td style="text-align:left;">80</td>
	<td style="text-align:left;">U 03B7</td>
	<td style="text-align:left;">π</td>
</tr>
<tr>
	<td style="text-align:left;">90</td>
	<td style="text-align:left;">U 03D9</td>
	<td style="text-align:left;">ϙ</td>
</tr>
</tbody>
</table>



 
**Hundreds digits**:

<table>
<colgroup>
<col style="text-align:left;"/>
<col style="text-align:left;"/>
<col style="text-align:left;"/>
</colgroup>

<thead>
<tr>
	<th style="text-align:left;">Numeric value</th>
	<th style="text-align:left;">Unicode code point</th>
	<th style="text-align:left;">Typical glyph</th>
</tr>
</thead>

<tbody>
<tr>
	<td style="text-align:left;">100</td>
	<td style="text-align:left;">U 03C0</td>
	<td style="text-align:left;">ρ</td>
</tr>
<tr>
	<td style="text-align:left;">200</td>
	<td style="text-align:left;">U 03C1</td>
	<td style="text-align:left;">σ</td>
</tr>
<tr>
	<td style="text-align:left;">300</td>
	<td style="text-align:left;">U 03C2</td>
	<td style="text-align:left;">τ</td>
</tr>
<tr>
	<td style="text-align:left;">400</td>
	<td style="text-align:left;">U 03C3</td>
	<td style="text-align:left;">υ</td>
</tr>
<tr>
	<td style="text-align:left;">500</td>
	<td style="text-align:left;">U 03C4</td>
	<td style="text-align:left;">φ</td>
</tr>
<tr>
	<td style="text-align:left;">600</td>
	<td style="text-align:left;">U 03C5</td>
	<td style="text-align:left;">χ</td>
</tr>
<tr>
	<td style="text-align:left;">700</td>
	<td style="text-align:left;">U 03C6</td>
	<td style="text-align:left;">ψ</td>
</tr>
<tr>
	<td style="text-align:left;">800</td>
	<td style="text-align:left;">U 03C7</td>
	<td style="text-align:left;">ω</td>
</tr>
<tr>
	<td style="text-align:left;">900</td>
	<td style="text-align:left;">U 03E1</td>
	<td style="text-align:left;">ϡ</td>
</tr>
</tbody>
</table>



Two other characters are valid digits:

-  Unicode upper case Μ (U 039C ) represents the numeric value 10,000 (μυριάς)
-  Unicode upper case Ο (U 039F) represents either a value of 0 or a null value (οὐδέν)

## Valid fractional characters ##

Fractional values as the denominator of a unit fraction: the integer value of the denominator is represented in the same way as whole integer units.  In addition, 
 two special characters abbreviating the common fractions 1/2 and 2/3 are allowed as alternatives, and are encode with the Unicode code points U 10175 ( 𐅵  = 1/2) and U 10177 (𐅷 = 2/3).

### Other valid characters ###

Three non-digit characters are valid:

- The space character (U 0020).  Within the integer component of a MilesianString, it has no value and is ignored; withint the fractional component, spaces separate unit fractions.  (See the [syntax specification of fractions](MilesianFractionSyntax.html).)  Output of a MilesianString object to a String uses the space between the integer and fractional components of the String to enhance readability.
- The single quote character terminates the integer component of the string.  
- The double quote terminates the fractional component of the string.

@openex@

### Examples ###

Lower case 
<strong concordion:set="#alpha">α</strong> is a 
<strong concordion:assertTrue="isDigit(#alpha)">valid digit</strong> character, but upper case 
<strong concordion:set="#big">Α</strong> is 
<strong concordion:assertFalse="isDigit(#big)">not</strong>.

Lower case <strong concordion:set="#omicron">ο</strong>
is a <strong concordion:assertTrue="isDigit(#omicron)">valid digit</strong> character
with a numeric value of 40, while upper case <strong concordion:set="#ouden">Ο</strong>
is a <strong concordion:assertTrue="isDigit(#ouden)">valid digit</strong> character indicating either 0 or a null value.

@closeex@




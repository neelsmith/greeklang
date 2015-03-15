# MilesianStrings

MilesianStrings are composed exclusively of characters relevant for numeric notation in the "Milesian" system: 27 characters for digits representing unit values 1-9, the tens values 10-90 and the hundreds values 100-900;  a character for the value 10,000 (μυριάς); a special character representing zero or a null value (οὐδέν); two characters abbreviating the fractions 1/2 and 2/3; and three punctuation characters used to distinguish integers from fractions, and to separate units of thousands from smaller units.

MilesianStrings are created from Strings by mapping Unicode code points on to the ancient Greek characters according to one of two mappings:

- a subset of the ancient Greek range of Unicode
- Strings using only ASCII characters following convetions of the TLG project's Beta Code



## Constructing MilesianStrings ##


### Valid digit characters ###



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
	<td style="text-align:left;">U 03DF</td>
	<td style="text-align:left;">ϟ</td>
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


### Other valid characters ###

Three non-digit characters are valid:

- The space (U 0020) is permitted anywhere in a String used to construct a MilesianString:  it has no value and is ignored;  output of a MilesianString object to a String uses the space between the integer and fractional components of the String to enhance readability.
- The single quote character marks the integer component of the string.  
- The double quote marks the fractional component.

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



## Syntax of MilesianStrings##

MilesianStrings may contain either or both of two components:  the first gives positive integers, the second gives fractional units.  If the string includes both components, the rightmost significant character of the integer component must be a single quote character, and the rightmost significant character of the fractional component must be a double quote character.  If the string consists only of a fractional component, the rightmost significant character must be a double quote character.  If the string consists only of an integer component, it may optionally include a single quote as the rightmost significant character.


@openex@
### Examples: integer and fractional components ###

The string <strong concordion:set="#longstr">ε' 𐅵 δ"</strong>
has two components. We can verify that it <strong concordion:assertTrue="hasIntegerPart(#longstr)">has an integer component</strong>, and determine that its integer component is <strong concordion:assertEquals="getIntegerPart(#longstr)">ε'</strong>, and its fractional component is <strong concordion:assertEquals="getFractionPart(#longstr)">𐅵 δ"</strong>.

The string <strong concordion:set="#five">ε</strong> has only one component.  We can determine that it
<strong concordion:assertTrue="hasIntegerPart(#five)">has an integer component</strong>, and that its integer component is 
<strong concordion:assertEquals="getIntegerPart(#five)">ε</strong>.

The string <strong concordion:set="#third">γ"</strong> (1/3) has only one component.  We can determine that it
<strong concordion:assertFalse="hasIntegerPart(#third)">does not have an integer component</strong>.



@closeex@

### Syntax of integer values < 1,000 ###


The Milesian system is essentially a place value system with distinct places for units, tens and hundreds.  Because units, tens and hundreds use distinct character ranges, however, there is no need of a 0 character.  

The order of units is right to left from smallest to largest.

@openex@
### Examples ###

The string <strong concordion:set="#ex365">τξε</strong> is a <strong concordion:assertTrue="isValid(#ex365)">valid string</strong> for the numeric value 365.


The string <strong concordion:set="#ex365space">τ ξ ε</strong>  (including white spaces )is also a <strong concordion:assertTrue="isValid(#ex365space)">valid string</strong> since white space is not significant.

The string <strong concordion:set="#ex305">τε</strong> (with no tens digit) is a <strong concordion:assertTrue="isValid(#ex305)">valid string</strong> for the numeric value 305.  

The string <strong concordion:set="#badval">ετ</strong> is <strong concordion:assertFalse="isValid(#badval)">NOT valid</strong> since its digits are not ordered right to left from smallest value to largest value.

@closeex@

### Syntax of integer values in the range 1,000..9,999 ###


For values of 1,000 - 9,000, the Milesian notation uses the same unit digits, but separated by a comma from the value < 1,000.


@openex@

### Examples ###

The string <strong concordion:set="#ex1001">α,α</strong> is a <strong concordion:assertTrue="isValid(#ex1001)">valid string</strong> for the numeric value 1001.


@closeex@

### Syntax of integer values in the range 9,999..19,999 ###

The value 10,000 is represented by upper case mu, Μ, for myriad.



values > 10,000 to left of M

values < 1,000 separated by comma from 1,000 to 9,999


@openex@


The string <strong concordion:set="#ex11001">Μα,α</strong> is a <strong concordion:assertTrue="isValid(#ex11001)">valid string</strong> for the numeric value 11,001.


@closeex@



## Fractions ##

chars represent unit fractions, plus two special ones:

one half 𐅵
U 10175

two thirds 𐅷
U 10177

syntax of string: separated by markers in continuous string


semantics: sum of values of unit fractions


@openex@

### Examples: fractions

The one-half char 
<strong concordion:set="#half">𐅵</strong> appears not to be covered in the Epidoc
transcoder:  it comes back unchanged from conversion to beta code as 
<strong assertEquals="toBetaCode(#half)">𐅵</strong>.


@closeex@


## ASCII-only representation of MilesianStrings##

Upper-case ASCII characters used, plus three "#" strings from TLG conventions:

- `#2` == ϛ (6)
- `#3` == ϟ (90)
- `#5` == ϡ (900)

@openex@



### Examples: alphabetic characters ###


Converting alphabetic α to a String yields <strong concordion:assertEquals="toStr(#alpha)">α</strong>.  Asking for it in ASCII yields <strong concordion:assertEquals="toBetaCode(#alpha)">A</strong>.


@closeex@

@openex@

### Examples: numeric digits

Converting the digit <strong concordion:set="#dig6">ϛ</strong>  (6) to ASCII yields
<strong concordion:assertEquals="toBetaCode(#dig6)">#2</strong>.

Converting the digit  <strong concordion:set="#dig90">ϟ</strong> (90) should yield `#3` but does not.


Converting the digit  <strong concordion:set="#dig900">ϡ</strong> (900) yields
<strong concordion:assertEquals="toBetaCode(#dig900)">#5</strong>.



@closeex@ 

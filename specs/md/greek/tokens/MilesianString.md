# MilesianStrings

MilesianStrings are composed exclusively of characters relevant for numeric notation in the "Milesian" system: 27 characters for digits representing unit values 1-9, the tens values 10-90 and the hundreds values 100-900;  a character for the value 10,000 (μυριάς); a special character representing zero or a null value (οὐδέν); two characters abbreviating the fractions 1/2 and 2/3; aand three punctuation characters used to distinguish integers from fractions, and to separate units of thousands from smaller units.

MilesianStrings are created from Strings by mapping Unicode code points on to the ancient Greek characters according to one of two mappings:

- a subset of the ancient Greek range of Unicode
- Strings using only ASCII characters following convetions of the TLG project's Beta Code



## Constructing and working with integers < 1,000 ##

The Milesian system is essentially a place value system with distinct places for units, tens and hundreds.  Because units, tens and hundreds use distinct character ranges, however, there is no need of a 0 character.  The order of units is right to left from smallest to largest.

MilesianStrings may be constructed from the following lower-case Unicode characters:

Ones digits:

| Numeric value | Unicode code point | Typical glyph |  
|  ------	| ------	| ------	|  
| 1 | U 03B1 | α |  
| 2 | U 03B2 | β |  
| 3 | U 03B3 | γ |  
| 4 | U 03B4 | δ |  
| 5 |  U 03B5| ε |  
| 6 | U 3DB | ϛ |  
| 7 |  U 03B6 | ζ |  
| 8 | U 03B7 | η |  
| 9 | U 03B8 | θ|  
 
Tens digits:

| Numeric value | Unicode code point | Typical glyph |  
|  ------	| ------	| ------	|  
| 10 | U 03B9 | ι |  
| 20 | U 03BA | κ |  
| 30 | U 03BB | λ |  
| 40 | U 03BC | μ |  
| 50 |  U 03BD| ν |  
| 60 | U 3DE | ξ |  
| 70 |  U 03BF | ο |  
| 80 | U 03B7 | π |  
| 90 | U 03DF | ϟ |  
 
Hundreds digits:

| Numeric value | Unicode code point | Typical glyph |  
|  ------	| ------	| ------	|  
| 100 | U 03C0 | ρ |  
| 200 | U 03C1 | σ |  
| 300 | U 03C2 | τ |  
| 400 | U 03C3 | υ |  
| 500 |  U 03C4| φ |  
| 600 | U 03C5 | χ|  
| 700 |  U 03C6 | ψ |  
| 800 | U 03C7 | ω |  
| 900 | U  03E1| ϡ |  



@openex@

### Examples ###

This lower case 
<strong concordion:set="#alpha">α</strong> is a 
<strong concordion:assertTrue="isDigit(#alpha)">valid digit</strong> character, but this upper case 
<strong concordion:set="#big">Α</strong> is 
<strong concordion:assertFalse="isDigit(#big)">not</strong>.

@closeex@



## Other characters ##

Unicode upper case mu == myriad.

Unicode upper case omicron == ouden.


## Syntax of larger values ##

values > 10,000 to left of M

values < 1,000 separated by comma from 1,000 to 9,999



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
<strong concordion:assertEquals="toBetaCode(#half)">𐅵</strong>.


@closeex@


## ASCII-only representation ##

Upper-case ASCII characters used, please "#" Strings from TLG conventions.

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
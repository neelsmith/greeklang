# Syntax of MilesianStrings #



MilesianStrings may contain either or both of two components:  the first gives positive integers, the second gives fractional units.  If the string includes both components, the rightmost significant character of the integer component must be a single quote character, and the rightmost significant character of the fractional component must be a double quote character.  If the string consists only of a fractional component, the rightmost significant character must be a double quote character.  If the string consists only of an integer component, it may optionally include a single quote as the rightmost significant character.

Within the integer component, white space is not significant:  only digit characters and the comma indicating the place column of thousands digits are considered in computing an integer value.

Fractional expresssions represent a sum of unit fractions.  White space separates unit fractions that should be added together.



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


## Syntax of individual components ##

- <a concordion:run="concordion" href="MilesianIntegerSyntax.html">Syntax of integer component</a>
- <a concordion:run="concordion" href="MilesianFractionSyntax.html">Syntax of fractional component</a>

## Syntax of integer values ##


### Integer values < 1,000 ###


The Milesian system is essentially a place value system with distinct places for units, tens and hundreds.  Because units, tens and hundreds use distinct character ranges, however, there is no need of a 0 character.  

The order of units is right to left from smallest to largest.

@openex@
### Examples ###

The string <strong concordion:set="#ex365">τξε</strong> is a <strong concordion:assertTrue="isValid(#ex365)">valid string</strong> for the numeric value 365.


The string <strong concordion:set="#ex365space">τ ξ ε</strong>  (including white spaces )is also a <strong concordion:assertTrue="isValid(#ex365space)">valid string</strong> since white space is not significant.

The string <strong concordion:set="#ex305">τε</strong> (with no tens digit) is a <strong concordion:assertTrue="isValid(#ex305)">valid string</strong> for the numeric value 305.  

The string <strong concordion:set="#badval">ετ</strong> is <strong concordion:assertFalse="isValid(#badval)">NOT valid</strong> since its digits are not ordered right to left from smallest value to largest value.

@closeex@

### Integer values in the range 1,000..9,999 ###


For values of 1,000 - 9,000, the Milesian notation uses the same unit digits, but separated by a comma from the value < 1,000.


@openex@

### Examples ###

The string <strong concordion:set="#ex1001">α,α</strong> is a <strong concordion:assertTrue="isValid(#ex1001)">valid string</strong> for the numeric value 1001.


@closeex@

### Integer values in the range 9,999..19,999 ###

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

A value corresponding to 7/12 is expressed as 1/2 + 1/7.

This could be done as β ιζ"





The one-half char 
<strong concordion:set="#half">𐅵</strong> appears not to be covered in the Epidoc
transcoder:  it comes back unchanged from conversion to beta code as 
<strong assertEquals="toBetaCode(#half)">𐅵</strong>.


@closeex@


#  Syntax of integer values 


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



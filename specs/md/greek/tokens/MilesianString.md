# MilesianStrings

MilesianStrings are composed exclusively of characters relevant for numeric notation in the "Milesian" system: 27 characters for digits representing unit values 1-9, tens values 10-90 and hundreds values 100-900;  a character for the value 10,000 (μυριάς); a special character representing zero or a null value (οὐδέν); and three punctuation characters used to distinguish integers from fractions, and to separate units of thousands from smaller units.

MilesianStrings are created from Strings by mapping Unicode code points on to the ancient Greek characters according to one of two mappings:

- a subset of the ancient Greek range of Unicode
- Strings using only ASCII characters following convetions of the TLG project's Beta Code

## Simple digits ##

Use only Unicode lower case characters for 27 digits.

Unicode upper case mu == myriad.

Unicode upper case omicron == ouden.

@openex@

### Examples ###

This lower case 
<strong concordion:set="#alpha">α</strong> is a 
<strong concordion:assertTrue="isDigit(#alpha)">valid digit</strong> character, but this upper case 
<strong concordion:set="#big">Α</strong> is 
<strong concordion:assertFalse="isDigit(#big)">not</strong>.

@closeex@


## Syntax of larger values ##

values > 10,000 to left of M

values < 1,000 separated by comma from 1,000 to 9,999



## Fractions ##

chars represent unit fractions, plus two special ones:

one half 𐅵
U 10175

two thrids 𐅷
U 10177

syntax of string: separated by markers in continuous string


semantics: sum of values of unit fractions
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

# Syntax of fractions #

Fractional values are expressed as sums of unit fractions.  Unit fractions are separated by whitespace, and give the denominator of the fraction using the same system used to write [integer values](MilesianIntegerSyntax.html), except that the two special abbreviations for 1/2 ( 𐅵 U 10175) and 2/3 (𐅷 U 10177) may used.  Unit fractions are listed from left to right in order from largest to smallest value.  The entire fractional component of a MilesianString is marked by a double quote character, optionally followed by non-signficant white space.







@openex@

### Examples: unit fractions ###

The fraction one-third is written <strong concordion:set="#third">γ"</strong>.  Its fractional component is <strong concordion:assertEquals="getFractionPart(#third)">γ"</strong>,  and it is
<strong concordion:assertTrue="isValid(#third)">syntactically valid</strong>.


The fraction one-half can be written with the abbreviation  <strong concordion:set="#half">𐅵"</strong>.  Its fractional component is <strong concordion:assertEquals="getFractionPart(#half)">𐅵"</strong>, 
<strong concordion:assertTrue="isValid(#half)">syntactically valid</strong>.

@closeex@

@openex@

### Examples:  sums of fractions

A value corresponding to 7/12 is expressed as 1/2 + 1/12.

As a MilesianString, this can be written as <strong concordion:set="#fract1">β ιβ"</strong>.  Its fractional component is <strong concordion:assertEquals="getFractionPart(#fract1)">β ιβ"</strong>, 
which parses as <strong concordion:assertTrue="isValid(#fract1)">syntactically valid</strong>.

Alternatively, the same value can be written with the abbreviation for 1/2 as 
<strong concordion:set="#abbr">𐅵 ιβ"</strong>.  Its
fractional part is 
<strong concordion:assertEquals="getFractionPart(#abbr)">𐅵 ιβ"</strong>,
which parses as <strong concordion:assertTrue="isValid(#abbr)">syntactically valid</strong>.




@closeex@


## ASCII-only representation ##

TO BE ADDED.

@openex@

The Unicode code points for the abbreviated fractions one-half
<strong concordion:set="#half">𐅵</strong> 
and <strong concordion:set="#twothirds">𐅷</strong>
are not yet covered in the Epidoc transcoder.  We need to define 
a mapping of these characters to an ASCII-only representation.

@closeex@
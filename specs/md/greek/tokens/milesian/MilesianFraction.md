# MilesianFractions #

In addition to verifying the syntax of the fractional component of a MilesianString, the MilesianFraction class can convert the fractional component of a MilesianString to both String representations and to floating point values.

The MilesianFraction class provides a method expressing the fraction as a String transcribing the sum of unit fractions.  Individual unit fractions are expressed as `1 /denominator`, where `denominator` is an integer;  series of unit fractions are joined by the string ` + `.

In converting MilesianFractions to decimal values, the default is to round the value to three decimal places, but the degree of precission may be explicitly defined.


@openex@

### Examples: string representations ###

The fraction 5/6 can be expressed in Milesian notation as <strong concordion:set="#twothirds">β γ"</strong>.  Its String representation is 
<strong concordion:assertEquals="xcribe(#twothirds)">1/2 + 1/3</strong>.

@closeex@




@openex@

### Examples: numeric representation ###

The above expresion for 2/3 can be converted to the decimal value
<strong concordion:assertEquals="toDecimal(#twothirds)">0.833</strong>.

Rounded to <strong concordion:set="#places">2</strong> places, this is
<strong concordion:assertEquals="toDecimal(#twothirds, #places)">0.83</strong>.

@closeex@



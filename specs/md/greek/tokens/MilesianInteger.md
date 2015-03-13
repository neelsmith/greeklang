# MilesianIntegers


Convert from MilesianString with simple integer to Integer.

Convert individual digits.

@openex@
### Example: individual digits ###

The digit <strong concordion:set="#alpha">α</strong> has the value 
<strong concordion:assertEquals="getDigitValue(#alpha)">1</strong>.


@closeex@



@openex@
### Example: integers < 1000 ###


The string <strong concordion:set="#ex111">ρια</strong> has the value 
<strong concordion:assertEquals="milesianToInteger(#ex111)">111</strong>.

@closeex@


@openex@
### Example: integers > 1000 ###


The string <strong concordion:set="#ex1001">α,α</strong> has the value 
<strong concordion:assertEquals="milesianToInteger(#ex1001)">1001</strong>.

@closeex@


@openex@
### Example: MAXINT in Milesian ###


The string <strong concordion:set="#maxex">Μθ,ϡϟθ</strong> has the value 
<strong concordion:assertEquals="milesianToInteger(#maxex)">19999</strong>.

@closeex@
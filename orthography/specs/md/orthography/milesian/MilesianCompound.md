# Compound values #

In addition to manipulating the integer and fractional components of a Milesian String individually, the MilesianString class can manipulate compound strings with both integer and fractional components.

Transcriptions represent the compound as a concatenation of the integer value of the integer component with the transcription of the fractional component as a sum of unit fractions.

Conversion to decimal values gives the sum of the value of the integer component and the fractional component.  The default precision of fractional components is three digits, but any number of digits may be specifically requested.

@openex@

### Examples ###

The string <strong concordion:set="#compound">δ' β ιβ"</strong>
has an integer part 
 <strong concordion:assertEquals="getIntegerPart(#compound)">δ'</strong>, and a fractional component  <strong concordion:assertEquals="getFractionPart(#compound)">β ιβ"</strong>.
It can be transcribed as 
<strong concordion:assertEquals="xscribe(#compound)">4 1/2 + 1/12</strong>.

Its decimal value is 
<strong concordion:assertEquals="toDecimal(#compound)">4.583</strong>.  Rounded to <strong concordion:set="#digs">2</strong> places, its decimal value is
<strong concordion:assertEquals="toDecimal(#compound, #digs)">4.58</strong>.
@closeex@



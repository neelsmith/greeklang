# Working with strings of Attic Greek

[$PROFILE$]: extended


## Creating valid strings

The specified representation of Attic strings mapped either to ASCII characters only or to the Greek range of Unicode allows for unambiguous [comparison and sorting of Attic strings](AtticSort.html).  It is convenient to support the following equivalent forms of input when creating an Attic string:

- ASCII mappings accept the lower-case equivalent of alphabetic characters
- Greek unicode mappings accept the upper-case equivalent of alphabetic characters
- Greek unicode mappings accept equivalent decomposed forms of vowels with breathing, accents or both




@openex@

### Examples of constructing Attic strings

The string <strong concordion:set="#src">DEMOS</strong> is a <strong concordion:assertTrue="isValidString(#src)">valid input form</strong> to create an Attic string in the ASCII mapping.

The string <strong concordion:set="#src">δεμος</strong> is a <strong concordion:assertTrue="isValidUString(#src)">valid input form</strong> to create an Attic string in the mapping to the Greek range of Unicode.

The string <strong concordion:set="#src">Demos</strong> is a <strong concordion:assertTrue="isValidString(#src)">valid input form</strong> to create an Attic string in the ASCII mapping.

The string <strong concordion:set="#src">Δεμος</strong> is a <strong concordion:assertTrue="isValidUString(#src)">valid input form</strong> to create an Attic string in the mapping to the Greek range of Unicode.


The string <strong concordion:set="#src">demos</strong> is a <strong concordion:assertTrue="isValidString(#src)">valid input form</strong> to create an Attic string in the ASCII mapping..

The string <strong concordion:set="#src">ΔΕΜΟΣ</strong> is a <strong concordion:assertTrue="isValidUString(#src)">valid input form</strong> to create an Attic string in the mapping to the Greek range of Unicode.


@closeex@



## String output of valid strings

Either of the specified representations in ASCII-only characters or in the Greek range of Unicode
can be generated for a given Attic string.


@openex@

### Examples: generating ASCII-only strings

Attic strings created from the Greek range of Unicode can also be represented in the ASCII-only mapping:

<table concordion:execute="#result = asciiForU(#src)">

<tr>
   <th concordion:set="#src">Constructed from</th>
  <th concordion:assertEquals="#result">As ASCII string</th>
</tr>
<tr><td>δεμος</td><td>DEMOS</td></tr>
<tr><td>Δεμος</td><td>DEMOS</td></tr>
<tr><td>ΔΕΜΟΣ</td><td>DEMOS</td></tr>
<tr><td>ΔΕ_ΜΟΣ</td><td>DE_MOS</td></tr>
<tr><td>δε=μος</td><td>DE=MOS</td></tr>
<tr><td>hοδός</td><td>HODO/S</td></tr>
</table>

Attic strings created from accepted ASCII input can be represented in the fully specified ASCII-only mapping:

<table concordion:execute="#result = regularAscii(#src)">

<tr>
   <th concordion:set="#src">Constructed from</th>
  <th concordion:assertEquals="#result">As ASCII string</th>
</tr>
<tr><td>demos</td><td>DEMOS</td></tr>
<tr><td>Demos</td><td>DEMOS</td></tr>
<tr><td>DEMOS</td><td>DEMOS</td></tr>
<tr><td>de_mos</td><td>DE_MOS</td></tr>
<tr><td>de=mos</td><td>DE=MOS</td></tr>
</table>

@closeex@



@openex@

### Examples: generating strings in the Greek range of Unicode

<table>
</table>



@closeex@

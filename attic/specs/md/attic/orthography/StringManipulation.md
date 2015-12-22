# Working with strings of Attic Greek

[$PROFILE$]: extended


## Creating valid strings

The specified representation of Attic strings mapped either to ASCII characters only or to the Greek range of Unicode allows for unambiguous [comparison and sorting of Attic strings](AtticSort.html).  It is convent to support the following equivalent forms of input when creating an Attic string:

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

# ASCII output of MilesianStrings


## ASCII-only representation of MilesianStrings##

Upper-case ASCII characters used, plus three "#" strings from TLG conventions:

- `#2` == ϛ (6)
- `#3` ==  ϙ (90)
- `#5` == ϡ (900)

@openex@



### Examples: alphabetic characters ###


Converting alphabetic <strong concordion:set="#alpha">α</strong> to a String yields <strong concordion:assertEquals="toStr(#alpha)">α</strong>.  Asking for it in ASCII yields <strong concordion:assertEquals="toBetaCode(#alpha)">A</strong>.


@closeex@

@openex@

### Examples: numeric digits

Converting the digit <strong concordion:set="#dig6">ϛ</strong>  (6) to ASCII yields
<strong concordion:assertEquals="toBetaCode(#dig6)">#2</strong>.

Converting the digit  <strong concordion:set="#dig90">ϙ</strong> (90) to ASCII yields <strong concordion:assertEquals="toBetaCode(#dig90)">#3</strong>


Converting the digit  <strong concordion:set="#dig900">ϡ</strong> (900) yields
<strong concordion:assertEquals="toBetaCode(#dig900)">#5</strong>.



@closeex@ 

#include "symbols.fst"

#consonant# = bgdzqklmncprstfxy
#vowel# = aeiouhw\|
#breathing# = \(\)
#letter# = #consonant# #vowel# #breathing#

#diaeresis# = \+
#accent# = \/\=
#diacritic# = #diaeresis# #accent#

#character# = #letter# #diacritic#


$consonant$ = [#consonant#]
$vowel$ = [#vowel#]
$vowel-sep$ = $vowel$ $vowel$ [#diaeresis#]:[#diaeresis#<>]
$vowel$ = ($vowel-sep$ | $vowel$)




$letter$ = ($consonant$ | $vowel$)

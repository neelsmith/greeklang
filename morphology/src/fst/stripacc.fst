% stripacc.fst:
%
% Remove accent characters from inflectional patterns
% for irregulars, and from stem strings for indeclinables.
%



% All symbols used in the FST:
#include "@workdir@symbols.fst"

#surfacesymbol# = #letter# #diaeresis#


#analysissymbol# =  #editorial# #morphtag# #stemtype# #separator# #accent# #urntag# #period# #urnchar#

ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
.*

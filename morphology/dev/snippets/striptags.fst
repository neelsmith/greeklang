% striptags.fst:

% All symbols used in the FST:
#include "../../build/fst/symbols.fst"


#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator#
% #extratag#

% #Xanalysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator#
#surfacesymbol# = #character#

ALPHABET =  [#surfacesymbol#] [#analysissymbol#]:<>
.*

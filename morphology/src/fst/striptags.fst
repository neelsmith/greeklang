% stripacc.fst:
%
% All symbols used in the FST:
#include "@workdir@symbols.fst"

#surfacesymbol# = #character#

% #Xanalysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# #extratag#

#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator#

ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
.*

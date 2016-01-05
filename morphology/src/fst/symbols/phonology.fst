% phonology.fst
%
% Definitions of all legal symbols in stem files (lexica) except for:
% 1. stem types (defined in stemtypes.fst)
% 2. URN values (generated by build process from stem files)
%
% Basic alphabet specific to this orthographic system:
#include "@workdir@symbols/alphabet.fst"


#diaeresis# = \+
#accent# = \/\=
#diacritic# = #diaeresis# #accent#

% Accents should only be included in entries for
% irregular forms!
#character# = #letter# #diacritic# #accent#
$character$ = [#character#]

% Additional editorial symbols used in stem files:
#morpheme# = <#>
#vowelquant# = <lo><sh>
#persistacc# = <stemultacc><stempenacc><inflacc><irregacc>
#editorial# = #vowelquant# #morpheme# #persistacc#


% All valid chars used in stem file:
#stemchars# = #character# #editorial#
#inmorpheme# = #character# #vowelquant# #persistacc#

% stemtypes.fst
%
% Definitions of morphological stem types used to unite stem entries and
% inflectional patterns
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Noun stem types
#noun1# = <a_hs><a_as><h_hs><hs_ou>
#noun2# = <os_ou><os_on>
#noun3# = <is_ios><is_ews><eus_ews><ma_matos>
#irregnoun# = <gunh>

#nounclass# = #noun1# #noun2# #noun3# #irregnoun#

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Adjective stem types
#adj1and2# = <os_h_on>

#adjectiveclass# = #adj1and2#


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Adverb stem types
#indecladv# = <indeclpos><indeclcomp><indeclsup>

#adverbclass# = #indecladv#

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Verb stem types
#omega# = <w_regular> <ew_contract> <aw_contract> <ow_contract>
#mi# = <mi_pres>

#verbclass#  = #omega#


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Indeclinable type
#indeclclass# = <indecl>


% Union of all stemtypes
#stemtype# = #nounclass# #adjectiveclass# #adverbclass# #verbclass# #indeclclass#

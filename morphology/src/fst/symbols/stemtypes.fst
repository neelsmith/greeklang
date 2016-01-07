% stemtypes.fst
%
% Definitions of morphological stem types used to unite stem entries and
% inflectional patterns
%
% Noun stem types
#noun1# = <a_hs><a_as><h_hs>
#noun2# = <os_ou><os_on><hs_ou>
#noun3# = <is_ios><is_ews><eus_ews>
#irregnoun# = <gunh>

#nounclass# = #noun1# #noun2# #noun3# #irregnoun#

% Verb stem types
#omega# = <w_regular> <ew_contract> <aw_contract> <ow_contract>
#mi# = <mi_pres>

#verbclass#  = #omega#

#othermorph# = <indecl>

% TBA: all other parts of speech
% adj
% ptcpl
% pronoun
% Various indeclinables


% Union of all stemtypes
#stemtype# = #nounclass# #verbclass# #othermorph#

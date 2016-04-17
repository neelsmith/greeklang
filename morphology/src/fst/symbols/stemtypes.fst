% stemtypes.fst
%
% Definitions of morphological stem types used to unite stem entries and
% inflectional patterns
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Noun stem types
#noun1# = <a_as><a_as_comp><a_as_long><a_as_short><a_hs><as_ou><as_ou_comp><h_hs><h_hs_comp><hs_ou><hs_ou_comp>

#noun2# = <os_ou><ous_ou><ous_ou_ult>


#labialpalatal3# = <y_pos><y_bos><c_kos><gc_ggos><c_gos><c_xos>
#dental3# = <s_tos><is_idos><is_itos><s_qos><s_ntos><wn_ontos>
#neuttau3# = <ma_matos><r_tos><s_tos>
#liquidnasal3# = <wr_oros><s_nos><wn_onos><hn_enos><null_os>
#rho3# = <hr_ros>
#sigma3# = <hs_ous><as_ws>
#iu3# = <is_ews><us_ews><us_uos>
#diphth3# = <eus_ews><w_ous>

#noun3# = #labialpalatal3#  #dental3# #neuttau3# #liquidnasal3# #rho3# #iu3#  #diphth3#

#nounclass# = #noun1# #noun2# #noun3#

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Adjective stem types
#adj1and2# = <os_h_on><os_a_on>

#adjectiveclass# = #adj1and2#


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Adverb stem types
#indecladv# = <indeclpos><indeclcomp><indeclsup>

#adverbclass# = #indecladv#

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Verb stem types
#omega# = <w_regular> <ew_contract> <short_ew_contract><aw_contract> <long_aw_contract><ow_contract> <w_pp1> <w_pp2> <w_pp3> <w_pp4> <w_pp5> <w_pp6> <aor2> <g_pp5> <m_pp5> <s_pp5> <sm_pp5> <gm_pp5> <vadj>
#mi# = <numi_pres>

#verbclass#  = #omega# #mi#


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Indeclinable type
#indeclclass# = <conjunct><particle><exclam><prepos>


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Irregular type
#irregclass# = <irregadj><irregnoun><irregadv><irregcverb><irreginfin><irregptcpl><irregvadj>

% Union of all stemtypes
#stemtype# = #nounclass# #adjectiveclass# #adverbclass# #verbclass# #indeclclass# #irregclass#

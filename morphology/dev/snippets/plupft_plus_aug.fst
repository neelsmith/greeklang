% test integration of augment in pluperfect

$aug$ = "<aug.a>"
$pp4$ =  "<pp4.a>"


$pp4$ || $aug$


%% Strings to test:
%
% Pass through a first part (unmodified stem) works OK:
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%
% FOURTH AND FIFTH PARTS:
%
% Perfect of luw is OK:
%<coretests.n64316_0><lexent.n64316><#>leluk<verb><w_regular>::<w_regular><w_indicative.43>a<1st><sg><pft><indic><act>
%
%
% COMPOUND FAILS:
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>leluk<verb><w_regular>::<w_regular><w_indicative.43>a<1st><sg><pft><indic><act>

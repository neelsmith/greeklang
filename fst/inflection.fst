%% inflection.fst

%%% Noun declensions
%
% First declension patterns:
%

%
% Second declension patterns:
%
$hs_ou_ending$ = <hs_ou> (hs[<masc>][<nom><voc>]<sg> |\
hn[<masc>]<acc><sg>)

$decl2noun_ending$ = $hs_ou_ending$


%
% Third declension patterns:
%
$is_ios_ending$ = <is_ios> (is<fem><nom><sg> |\
i<fem><voc><sg>|\
in<fem><acc><sg> )


$eus_ews_ending$ = <eus_ews> (eus[<masc>][<nom><voc>]<sg> |\
ews[<masc>]<gen><sg> )

$decl3noun_ending$ = $is_ios_ending$ | $eus_ews_ending$





$ending$ = $decl2noun_ending$ | $decl3noun_ending$

$ending$

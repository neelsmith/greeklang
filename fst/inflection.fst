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
$is_ios_ending$ = <is_ios> (is[<masc><fem>]<nom><sg> |\
ios[<masc><fem>]<gen><sg> |\
i[<masc><fem>]<dat><sg> |\
in[<masc><fem>]<acc><sg> |\
i[<masc><fem>]<voc><sg> |\
ies[<masc><fem>]<nom><pl> )


$eus_ews_ending$ = <eus_ews> (eus[<masc>][<nom><voc>]<sg> |\
ews[<masc>]<gen><sg> |\
ei[<masc>]<dat><sg> |\
ea[<masc>]<acc><sg> |\
h[<masc>]<acc><sg>)

$decl3noun_ending$ = $is_ios_ending$ | $eus_ews_ending$



$ending$ = $decl2noun_ending$ | $decl3noun_ending$

$ending$

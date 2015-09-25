%%% Noun declensions
%
% First declension patterns:
%
$a_as_ending$ = <a_as> (a<fem><nom><sg> |\
  as<fem><gen><sg> |\
  a\|<fem><dat><sg> |\
  an<fem><acc><sg> |\
  a<fem><voc><sg> |\
  ai[<masc><fem>]<nom><pl> \
)

$hs_ou_ending$ = <hs_ou> (hs[<masc>][<nom><voc>]<sg> |\
hn[<masc>]<acc><sg>)

$decl1noun_ending$ = $a_as_ending$ | $hs_ou_ending$

%
% Second declension patterns:
%

$os_ou_ending$ = <os_ou> (os[<masc><fem>]<nom><sg> |\
  ou[<masc><fem>]<gen><sg> |\
  w\|[<masc><fem>]<dat><sg> |\
  on[<masc><fem>]<acc><sg> |\
  oi[<masc><fem>]<nom><pl> |\
  wn[<masc><fem>]<gen><pl> |\
  ois[<masc><fem>]<dat><pl> |\
  ous[<masc><fem>]<acc><pl> \
)

$decl2noun_ending$ = $os_ou_ending$


%
% Third declension patterns:
%
$is_ios_ending$ = <is_ios> (is[<masc><fem>]<nom><sg> |\
  ios[<masc><fem>]<gen><sg> |\
  i[<masc><fem>]<dat><sg> |\
  in[<masc><fem>]<acc><sg> |\
  i[<masc><fem>]<voc><sg> |\
  ies[<masc><fem>]<nom><pl> \
)


$eus_ews_ending$ = <eus_ews> (eus[<masc>][<nom><voc>]<sg> |\
  ews[<masc>]<gen><sg> |\
  ei[<masc>]<dat><sg> |\
  ea[<masc>]<acc><sg> |\
  h[<masc>]<acc><sg> |\
  eis[<masc>]<nom><pl> |\
  ewn[<masc>]<gen><pl> |\
  eusi[<masc>]<dat><pl> |\
  eas[<masc>]<acc><pl> \
)

$decl3noun_ending$ = $is_ios_ending$ | $eus_ews_ending$



$nouninfl$ = $decl1noun_ending$ | $decl2noun_ending$ | $decl3noun_ending$

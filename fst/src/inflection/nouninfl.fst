%%% Noun declensions
%
% First declension patterns:
%
$a_as_ending$ = <a_as> (a<fem><nom><sg> |\
  as<fem><gen><sg> |\
  a\|<fem><dat><sg> |\
  an<fem><acc><sg> |\
  a<fem><voc><sg> |\
  ai[<masc><fem>]<nom><pl> |\
  wn[<masc><fem>]<nom><gen> |\
  ais[<masc><fem>]<nom><dat> |\
  as[<masc><fem>]<nom><acc> \
)

$hs_ou_ending$ = <hs_ou> (hs[<masc>][<nom><voc>]<sg> |\
  ou[<masc>]<gen><sg> |\
  h\|[<masc>]<dat><sg> |\
  hn[<masc>]<acc><sg> |\
  ai[<masc>]<nom><pl> |\
  wn[<masc>]<gen><pl> |\
  ais|[<masc>]<dat><pl> |\
  as[<masc>]<acc><pl> \
)

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
  ies[<masc><fem>]<nom><pl> |\
  iwn[<masc><fem>]<gen><pl> |\
  isi[<masc><fem>]<dat><pl> |\
  ies[<masc><fem>]<acc><pl> \
)


$is_ews_ending$ = <is_ews> (is[<masc><fem>]<nom><sg> |\
  ews[<masc><fem>]<gen><sg> |\
  ei[<masc><fem>]<dat><sg> |\
  in[<masc><fem>]<acc><sg> |\
  i[<masc><fem>]<voc><sg> |\
  eis[<masc><fem>]<nom><pl> |\
  ewn[<masc><fem>]<gen><pl> |\
  esi[<masc><fem>]<dat><pl> |\
  eis[<masc><fem>]<acc><pl> \
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

$decl3noun_ending$ = $is_ios_ending$ | $is_ews_ending$ | $eus_ews_ending$



$nouninfl$ = $decl1noun_ending$ | $decl2noun_ending$ | $decl3noun_ending$

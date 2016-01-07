%%% Noun declensions
%
% First declension patterns:
$h_hs_ending$ = <h_hs> (<u>nouninfl\.h\_hs1</u>h[<masc><fem>]<nom><sg> |\
<u>nouninfl\.h\_hs2</u>hs[<masc><fem>]<gen><sg> |\
<u>nouninfl\.h\_hs3</u>h\|[<masc><fem>]<dat><sg> |\
<u>nouninfl\.h\_hs4</u>hn[<masc><fem>]<acc><sg> |\
<u>nouninfl\.h\_hs5</u>h[<masc><fem>]<voc><sg> |\
<u>nouninfl\.h\_hs6</u>ai[<masc><fem>]<nom><pl> |\
<u>nouninfl\.h\_hs7</u>wn[<masc><fem>]<gen><pl> |\
<u>nouninfl\.h\_hs8</u>ais[<masc><fem>]<dat><pl> |\
<u>nouninfl\.h\_hs9</u>a<lo>s[<masc><fem>]<acc><pl> |\
<u>nouninfl\.h\_hs10</u>ai[<masc><fem>]<voc><pl> \
)
%
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

$decl1noun_ending$ = $a_as_ending$ | $h_hs_ending$ | $hs_ou_ending$

$decl1noun_ending$ 

%%% Noun declensions: first declension patterns:
%
% Example: βούλη, βούλης
$h_hs_ending$ = <h_hs> (<u>nouninfl\.h\_hs1</u>h<fem><nom><sg> |\
<u>nouninfl\.h\_hs2</u>hs<fem><gen><sg> |\
<u>nouninfl\.h\_hs3</u>h\|<fem><dat><sg> |\
<u>nouninfl\.h\_hs4</u>hn<fem><acc><sg> |\
<u>nouninfl\.h\_hs5</u>h<fem><voc><sg> |\
<u>nouninfl\.h\_hs6</u>ai<fem><nom><pl> |\
<u>nouninfl\.h\_hs7</u>wn<fem><gen><pl> |\
<u>nouninfl\.h\_hs8</u>ais<fem><dat><pl> |\
<u>nouninfl\.h\_hs9</u>a<lo>s<fem><acc><pl> |\
<u>nouninfl\.h\_hs10</u>ai<fem><voc><pl> \
)
%
% Example:  θάλαττα, θαλάττης
$a_hs_ending$ = <a_hs> (<u>nouninfl\.a\_hs1</u>a<sh><fem><nom><sg> |\
<u>nouninfl\.a\_hs2</u>hs<fem><gen><sg> |\
<u>nouninfl\.a\_hs3</u>h\|<fem><dat><sg> |\
<u>nouninfl\.a\_hs4</u>a<sh>n<fem><acc><sg> |\
<u>nouninfl\.a\_hs5</u>a<sh><fem><voc><sg> |\
<u>nouninfl\.a\_hs6</u>ai<fem><nom><pl> |\
<u>nouninfl\.a\_hs7</u>wn<fem><gen><pl> |\
<u>nouninfl\.a\_hs8</u>ais<fem><dat><pl> |\
<u>nouninfl\.a\_hs9</u>a<lo>s<fem><acc><pl> |\
<u>nouninfl\.a\_hs10</u>ai<fem><voc><pl> \
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

$decl1noun_ending$ = $a_as_ending$ | $a_hs_ending$ | $h_hs_ending$ | $hs_ou_ending$

$decl1noun_ending$

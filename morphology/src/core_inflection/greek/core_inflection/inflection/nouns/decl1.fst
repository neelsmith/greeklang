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
% Example: χώρα, χώρας
$a_as_ending$ = <a_as> (<u>nouninfl\.a\_as1</u>a<lo><fem><nom><sg> |\
  <u>nouninfl\.a\_as2</u>a<lo>s<fem><gen><sg> |\
  <u>nouninfl\.a\_as3</u>a<lo>\|<fem><dat><sg> |\
  <u>nouninfl\.a\_as4</u>a<lo>n<fem><acc><sg> |\
  <u>nouninfl\.a\_as5</u>a<lo><fem><voc><sg> |\
  <u>nouninfl\.a\_as6</u>ai<fem><nom><pl> |\
  <u>nouninfl\.a\_as7</u>wn<fem><gen><pl> |\
  <u>nouninfl\.a\_as8</u>ais<fem><dat><pl> |\
  <u>nouninfl\.a\_as9</u>a<lo>s<fem><acc><pl> \
)

$hs_ou_ending$ = <hs_ou> (<u>nouninfl\.hs\_ou1</u>hs[<masc>][<nom><voc>]<sg> |\
  <u>nouninfl\.hs\_ou2</u>ou[<masc>]<gen><sg> |\
  <u>nouninfl\.hs\_ou3</u>h\|[<masc>]<dat><sg> |\
  <u>nouninfl\.hs\_ou4</u>hn[<masc>]<acc><sg> |\
  <u>nouninfl\.hs\_ou5</u>ai[<masc>]<nom><pl> |\
  <u>nouninfl\.hs\_ou6</u>wn[<masc>]<gen><pl> |\
  <u>nouninfl\.hs\_ou7</u>ais|[<masc>]<dat><pl> |\
  <u>nouninfl\.hs\_ou8</u>as[<masc>]<acc><pl> \
)

$decl1noun_ending$ = $a_as_ending$ | $a_hs_ending$ | $h_hs_ending$ | $hs_ou_ending$

$decl1noun_ending$

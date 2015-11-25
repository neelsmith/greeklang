%%% Noun declensions
%
% First declension patterns:
$h_hs_ending$ = <h\_hs> (<u>nouninfl\.h\_hs1</u>h[<masc><fem>]<nom><sg> |\
<u>nouninfl\.h\_hs2</u>hs[<masc><fem>]<gen><sg> |\
<u>nouninfl\.h\_hs3</u>h|[<masc><fem>]<dat><sg> |\
<u>nouninfl\.h\_hs4</u>hn[<masc><fem>]<acc><sg> |\
<u>nouninfl\.h\_hs5</u>h[<masc><fem>]<voc><sg> |\
<u>nouninfl\.h\_hs6</u>ai[<masc><fem>]<nom><pl> |\
<u>nouninfl\.h\_hs7</u>wn[<masc><fem>]<gen><pl> |\
<u>nouninfl\.h\_hs8</u>ais[<masc><fem>]<dat><pl> |\
<u>nouninfl\.h\_hs9</u>as[<masc><fem>]<acc><pl> \
)
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

$decl1noun_ending$ = $a_as_ending$ | h_hs_ending | $hs_ou_ending$

%
% Second declension patterns:
%

$os_ou_ending$ = <os_ou> (<u>nouninfl\.os\_ou1</u>os[<masc><fem>]<nom><sg> |\
  <u>nouninfl\.os\_ou1</u>on<neut><nom><sg> |\
  <u>nouninfl\.os\_ou2</u>ou[<masc><fem><neut>]<gen><sg> |\
  <u>nouninfl\.os\_ou3</u>w\|[<masc><fem><neut>]<dat><sg> |\
  <u>nouninfl\.os\_ou4</u>on[<masc><fem><neut>]<acc><sg> |\
  <u>nouninfl\.os\_ou5</u>e[<masc><fem><neut>]<voc><sg> |\
  <u>nouninfl\.os\_ou6</u>oi[<masc><fem><neut>]<nom><pl> |\
  <u>nouninfl\.os\_ou7</u>wn[<masc><fem><neut>]<gen><pl> |\
  <u>nouninfl\.os\_ou8</u>ois[<masc><fem><neut>]<dat><pl> |\
  <u>nouninfl\.os\_ou9</u>ous[<masc><fem>]<acc><pl> |\
    <u>nouninfl\.os\_ou10</u>a<neut><acc><pl>  \
)

$decl2noun_ending$ = $os_ou_ending$


%
% Third declension patterns:
%
$is_ios_ending$ = <is\_ios> (<u>nouninfl\.is\_ios1</u>is[<masc><fem>]<nom><sg> |\
  <u>nouninfl\.is\_ios2</u>ios[<masc><fem>]<gen><sg> |\
  <u>nouninfl\.is\_ios3</u>i[<masc><fem>]<dat><sg> |\
  <u>nouninfl\.is\_ios4</u>in[<masc><fem>]<acc><sg> |\
  <u>nouninfl\.is\_ios5</u>i[<masc><fem>]<voc><sg> |\
  <u>nouninfl\.is\_ios6</u>ies[<masc><fem>]<nom><pl> |\
  <u>nouninfl\.is\_ios7</u>iwn[<masc><fem>]<gen><pl> |\
  <u>nouninfl\.is\_ios8</u>isi[<masc><fem>]<dat><pl> |\
  <u>nouninfl\.is\_ios9</u>ies[<masc><fem>]<acc><pl> \
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
  eu[<masc><fem>]<voc><sg> |\
  eis[<masc>]<nom><pl> |\
  ewn[<masc>]<gen><pl> |\
  eusi[<masc>]<dat><pl> |\
  eas[<masc>]<acc><pl> \
)

$decl3noun_ending$ = $is_ios_ending$ | $is_ews_ending$ | $eus_ews_ending$


% Sum it all up:
$nouninfll$ = $decl1noun_ending$ | $decl2noun_ending$ | $decl3noun_ending$
$nouninfll$

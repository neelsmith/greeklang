%%% Noun declensions
%
% First declension patterns:
$h_hs_ending$ = <h_hs> (<u>nouninfl\.h\_hs1</u>E[<masc><fem>]<nom><sg> |\
<u>nouninfl\.h\_hs2</u>ES[<masc><fem>]<gen><sg> |\
<u>nouninfl\.h\_hs3</u>EI[<masc><fem>]<dat><sg> |\
<u>nouninfl\.h\_hs4</u>EN[<masc><fem>]<acc><sg> |\
<u>nouninfl\.h\_hs5</u>E[<masc><fem>]<voc><sg> |\
<u>nouninfl\.h\_hs6</u>AI[<masc><fem>]<nom><pl> |\
<u>nouninfl\.h\_hs7</u>ON[<masc><fem>]<gen><pl> |\
<u>nouninfl\.h\_hs8</u>AIS[<masc><fem>]<dat><pl> |\
<u>nouninfl\.h\_hs9</u>A<lo>S[<masc><fem>]<acc><pl> |\
<u>nouninfl\.h\_hs10</u>AI[<masc><fem>]<voc><pl> \
)
%
$decl1noun_ending$ = $h_hs_ending$



$os_ou_ending$ = <os_ou> (<u>nouninfl\.os\_ou1</u>O<sh>S[<masc><fem>]<nom><sg> |\
  <u>nouninfl\.os\_ou14</u>O<sh>N<neut><nom><sg> |\
  <u>nouninfl\.os\_ou2</u>O<lo>[<masc><fem><neut>]<gen><sg> |\
  <u>nouninfl\.os\_ou3</u>O<lo>I[<masc><fem><neut>]<dat><sg> |\
  <u>nouninfl\.os\_ou4</u>O<sh>N[<masc><fem><neut>]<acc><sg> |\
  <u>nouninfl\.os\_ou5</u>E<sh>[<masc><fem>]<voc><sg> |\
  <u>nouninfl\.os\_ou6</u>OI[<masc><fem>]<nom><pl> |\
  <u>nouninfl\.os\_ou15</u>A<neut><nom><pl> |\
  <u>nouninfl\.os\_ou7</u>O<lo>N[<masc><fem><neut>]<gen><pl> |\
  <u>nouninfl\.os\_ou8</u>OIS[<masc><fem><neut>]<dat><pl> |\
  <u>nouninfl\.os\_ou9</u>O<lo>S[<masc><fem>]<acc><pl> |\
    <u>nouninfl\.os\_ou10</u>A<neut><acc><pl>  |\
    <u>nouninfl\.os\_ou11</u>O<lo>N[<neut>]<voc><sg> |\
    <u>nouninfl\.os\_ou12</u>OI[<masc><fem>]<voc><pl> |\
    <u>nouninfl\.os\_ou13</u>A[<neut>]<voc><pl> \
)

$decl2noun_ending$ = $os_ou_ending$

% Sum it all up:
$nouninfll$ = $decl1noun_ending$ | $decl2noun_ending$
$nouninfll$

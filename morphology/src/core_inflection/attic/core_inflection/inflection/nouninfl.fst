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
<u>nouninfl\.h\_hs9</u>A<lo>s[<masc><fem>]<acc><pl> |\
<u>nouninfl\.h\_hs10</u>AI[<masc><fem>]<voc><pl> \
)
%


$decl1noun_ending$ = $h_hs_ending$


% Sum it all up:
$nouninfll$ = $decl1noun_ending$
$nouninfll$

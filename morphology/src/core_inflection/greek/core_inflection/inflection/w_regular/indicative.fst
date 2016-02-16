% indicative\.fst
% Inflectional patterns for indicative mood of regular omega verbs
%
% Currently includes pres, impft, fut, aor and perf in all 3 voices.
%
% Pluperfect, fut. perfect not yet added
%

% Present and future indicative endings:
$w_presfut_indic_ending$ = <w_regular> ( \
    w<1st><sg>[<pres><fut>]<indic><act><u>verbinfl\.w\_indicative1</u> |\
    eis<2nd><sg>[<pres><fut>]<indic><act><u>verbinfl\.w\_indicative2</u> |\
    ei<3rd><sg>[<pres><fut>]<indic><act><u>verbinfl\.w\_indicative3</u> |\
    omen<1st><pl>[<pres><fut>]<indic><act><u>verbinfl\.w\_indicative4</u> |\
    ete<2nd><pl>[<pres><fut>]<indic><act><u>verbinfl\.w\_indicative5</u> |\
    ousi<3rd><pl>[<pres><fut>]<indic><act><u>verbinfl\.w\_indicative6</u> |\
    \
    omai<1st><sg>[<pres><fut>]<indic>[<mid><pass>]<u>verbinfl\.w\_indicative7</u> |\
    ei<2nd><sg>[<pres><fut>]<indic>[<mid><pass>]<u>verbinfl\.w\_indicative8</u> |\
    etai<3rd><sg>[<pres><fut>]indic>[<mid><pass>]<u>verbinfl\.w\_indicative9</u> |\
    omeqa<1st><pl>[<pres><fut>]<indic>[<mid><pass>]<u>verbinfl\.w\_indicative10</u> |\
    esqe<2nd><pl>[<pres><fut>]<indic>[<mid><pass>]<u>verbinfl\.w\_indicative11</u> |\
    ontai<3rd><pl>[<pres><fut>]<indic>[<mid><pass>]<u>verbinfl\.w\_indicative12</u>  |\
    \
    hsomai<1st><sg><fut><indic><pass><u>verbinfl\.w\_indicative67</u> |\
    hsei<2nd><sg><fut><indic><pass><u>verbinfl\.w\_indicative68</u> |\
    hsetai<3rd><sg><fut><indic><pass><u>verbinfl\.w\_indicative69</u> |\
    hsomeqa<1st><pl><fut><indic><pass><u>verbinfl\.w\_indicative70</u> |\
    hsesqe<2nd><pl><fut><indic><pass><u>verbinfl\.w\_indicative71</u> |\
    hsontai<3rd><pl><fut><indic><pass><u>verbinfl\.w\_indicative72</u> \
)

% Imperfect indicative:
$w_imperfect_ending$ = <w_regular> ( \
    on<1st><sg><impft><indic><act><u>verbinfl\.w\_indicative13</u> |\
    es<2nd><sg><impft><indic><act><u>verbinfl\.w\_indicative14</u> |\
    e<3rd><sg><impft><indic><act><u>verbinfl\.w\_indicative15</u> |\
    omen<1st><pl><impft><indic><act><u>verbinfl\.w\_indicative16</u> |\
    ete<2nd><pl><impft><indic><act><u>verbinfl\.w\_indicative17</u> |\
    on<3rd><pl><impft><indic><act><u>verbinfl\.w\_indicative18</u> |\
    \
    omhn<1st><sg><impft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative19</u> |\
    ou<2nd><sg><impft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative20</u> |\
    eto<3rd><sg><impft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative21</u> |\
    omeqa<1st><pl><impft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative22</u> |\
    esqe<2nd><pl><impft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative23</u> |\
    onto<3rd><pl><impft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative24</u> \
    \
)


% First aorist
$aor1_indic_ending$ = <w_regular> ( \
    a<1st><sg><aor><indic><act><u>verbinfl\.w\_indicative25</u> |\
    as<2nd><sg><aor><indic><act><u>verbinfl\.w\_indicative26</u> |\
    e<3rd><sg><aor><indic><act><u>verbinfl\.w\_indicative27</u> |\
    amen<1st><pl><aor><indic><act><u>verbinfl\.w\_indicative28</u> |\
    ate<2nd><pl><aor><indic><act><u>verbinfl\.w\_indicative29</u> |\
    an<3rd><pl><aor><indic><act><u>verbinfl\.w\_indicative30</u> |\
    \
    mhn<1st><sg><aor><indic><mid><u>verbinfl\.w\_indicative31</u> |\
    w<2nd><sg><aor><indic><mid><u>verbinfl\.w\_indicative32</u> |\
    ato<3rd><sg><aor><indic><mid><u>verbinfl\.w\_indicative33</u> |\
    ameqa<1st><pl><aor><indic><mid><u>verbinfl\.w\_indicative34</u> |\
    asqe<2nd><pl><aor><indic><mid><u>verbinfl\.w\_indicative35</u> |\
    anto<3rd><pl><aor><indic><mid><u>verbinfl\.w\_indicative36</u> |\
    \
    hn<1st><sg><aor><indic><pass><u>verbinfl\.w\_indicative37</u> |\
    hs<2nd><sg><aor><indic><pass><u>verbinfl\.w\_indicative38</u> |\
    h<3rd><sg><aor><indic><pass><u>verbinfl\.w\_indicative39</u> |\
    hmen<1st><pl><aor><indic><pass><u>verbinfl\.w\_indicative40</u> |\
    hte<2nd><pl><aor><indic><pass><u>verbinfl\.w\_indicative41</u> |\
    hsan<3rd><pl><aor><indic><pass><u>verbinfl\.w\_indicative42</u> \
    \
)


% Perfect act, mid, passive:
$pft_indic_ending$ = <w_regular> ( \
    a<1st><sg><pft><indic><act><u>verbinfl\.w\_indicative43</u> |\
    as<2nd><sg><pft><indic><act><u>verbinfl\.w\_indicative44</u> |\
    e<3rd><sg><pft><indic><act><u>verbinfl\.w\_indicative45</u> |\
    amen<1st><pl><pft><indic><act><u>verbinfl\.w\_indicative46</u> |\
    ate<2nd><pl><pft><indic><act><u>verbinfl\.w\_indicative47</u> |\
    asi<3rd><pl><pft><indic><act><u>verbinfl\.w\_indicative48</u> |\
    \
    mai<1st><sg><pft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative49</u> |\
    sai<2nd><sg><pft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative50</u> |\
    tai<3rd><sg><pft>indic>[<mid><pass>]<u>verbinfl\.w\_indicative51</u> |\
    meqa<1st><pl><pft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative52</u> |\
    sqe<2nd><pl><pft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative53</u> |\
    ntai<3rd><pl><pft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative54</u>  \
    \
)


% Pluperfect act, mid, passive:
$plupft_indic_ending$ = <w_regular> ( \
  h<1st><sg><plupft><indic><act><u>verbinfl\.w\_indicative55</u> |\
  hs<2nd><sg><plupft><indic><act><u>verbinfl\.w\_indicative56</u> |\
  ei<3rd><sg><plupft><indic><act><u>verbinfl\.w\_indicative57</u> |\
  emen<1st><pl><plupft><indic><act><u>verbinfl\.w\_indicative58</u> |\
  ete<2nd><pl><plupft><indic><act><u>verbinfl\.w\_indicative59</u> |\
  esan<3rd><pl><plupft><indic><act><u>verbinfl\.w\_indicative60</u> |\
  \
  mhn<1st><sg><plupft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative61</u> |\
  so<2nd><sg><plupft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative62</u> |\
  to<3rd><sg><plupft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative63</u> |\
  meqa<1st><pl><plupft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative64</u> |\
  sqe<2nd><pl><plupft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative65</u> |\
  nto<3rd><pl><plupft><indic>[<mid><pass>]<u>verbinfl\.w\_indicative66</u> \
)

$w\_indicative$ = ( $w_presfut_indic_ending$ | $w_imperfect_ending$ | $aor1_indic_ending$ | $pft_indic_ending$ | $plupft_indic_ending$)


$w\_indicative$

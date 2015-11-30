% indicative\.fst
% Inflectional patterns for indicative mood of regular omega verbs
%
% Currently includes pres, impft, fut, aor and perf in all 3 voices.
%
% Pluperfect, fut. perfect not yet added
%

% Present and future indicative endings:
$w_presfut_indic_ending$ = <w_regular> ( \
    w<1st><sg>[<pres><fut>]<indic><act><u>w_indicative\.1</u> |\
    eis<2nd><sg>[<pres><fut>]<indic><act><u>w_indicative\.2</u> |\
    ei<3rd><sg>[<pres><fut>]<indic><act><u>w_indicative\.3</u> |\
    omen<1st><pl>[<pres><fut>]<indic><act><u>w_indicative\.4</u> |\
    ete<2nd><pl>[<pres><fut>]<indic><act><u>w_indicative\.5</u> |\
    ousi<3rd><pl>[<pres><fut>]<indic><act><u>w_indicative\.6</u> |\
    \
    omai<1st><sg>[<pres><fut>]<indic><mid><u>w_indicative\.7</u> |\
    ei<2nd><sg>[<pres><fut>]<indic><mid><u>w_indicative\.8</u> |\
    etai<3rd><sg>[<pres><fut>]indic><mid><u>w_indicative\.9</u> |\
    omeqa<1st><pl>[<pres><fut>]<indic><mid><u>w_indicative\.10</u> |\
    esqe<2nd><pl>[<pres><fut>]<indic><mid><u>w_indicative\.11</u> |\
    ontai<3rd><pl>[<pres><fut>]<indic><mid><u>w_indicative\.12</u>  |\
    \
    hsomai<1st><sg><fut><indic><pass><u>w_indicative\.67</u> |\
    hsei<2nd><sg><fut><indic><pass><u>w_indicative\.68</u> |\
    hsetai<3rd><sg><fut><indic><pass><u>w_indicative\.69</u> |\
    hsomeqa<1st><pl><fut><indic><pass><u>w_indicative\.70</u> |\
    hsesqe<2nd><pl><fut><indic><pass><u>w_indicative\.71</u> |\
    hsontai<3rd><pl><fut><indic><pass><u>w_indicative\.72</u> \
)

% Imperfect indicative:
$w_imperfect_ending$ = <w_regular> ( \
    on<1st><sg><impft><indic><act><u>w_indicative\.13</u> |\
    es<2nd><sg><impft><indic><act><u>w_indicative\.14</u> |\
    e<3rd><sg><impft><indic><act><u>w_indicative\.15</u> |\
    omen<1st><pl><impft><indic><act><u>w_indicative\.16</u> |\
    ete<2nd><pl><impft><indic><act><u>w_indicative\.17</u> |\
    on<3rd><pl><impft><indic><act><u>w_indicative\.18</u> |\
    \
    omhn<1st><sg><impft><indic>[<mid><pass>]<u>w_indicative\.19</u> |\
    ou<2nd><sg><impft><indic>[<mid><pass>]<u>w_indicative\.20</u> |\
    eto<3rd><sg><impft><indic>[<mid><pass>]<u>w_indicative\.21</u> |\
    omeqa<1st><pl><impft><indic>[<mid><pass>]<u>w_indicative\.22</u> |\
    esqe<2nd><pl><impft><indic>[<mid><pass>]<u>w_indicative\.23</u> |\
    onto<3rd><pl><impft><indic>[<mid><pass>]<u>w_indicative\.24</u> \
    \
)


% First aorist
$aor1_indic_ending$ = <w_regular> ( \
    a<1st><sg><aor><indic><act><u>w_indicative\.25</u> |\
    as<2nd><sg><aor><indic><act><u>w_indicative\.26</u> |\
    e<3rd><sg><aor><indic><act><u>w_indicative\.27</u> |\
    amen<1st><pl><aor><indic><act><u>w_indicative\.28</u> |\
    ate<2nd><pl><aor><indic><act><u>w_indicative\.29</u> |\
    an<3rd><pl><aor><indic><act><u>w_indicative\.30</u> |\
    \
    mhn<1st><sg><aor><indic><mid><u>w_indicative\.31</u> |\
    w<2nd><sg><aor><indic><mid><u>w_indicative\.32</u> |\
    ato<3rd><sg><aor><indic><mid><u>w_indicative\.33</u> |\
    ameqa<1st><pl><aor><indic><mid><u>w_indicative\.34</u> |\
    asqe<2nd><pl><aor><indic><mid><u>w_indicative\.35</u> |\
    anto<3rd><pl><aor><indic><mid><u>w_indicative\.36</u> |\
    \
    hn<1st><sg><aor><indic><pass><u>w_indicative\.37</u> |\
    hs<2nd><sg><aor><indic><pass><u>w_indicative\.38</u> |\
    h<3rd><sg><aor><indic><pass><u>w_indicative\.39</u> |\
    hmen<1st><pl><aor><indic><pass><u>w_indicative\.40</u> |\
    hte<2nd><pl><aor><indic><pass><u>w_indicative\.41</u> |\
    hsan<3rd><pl><aor><indic><pass><u>w_indicative\.42</u> \
    \
)


% Perfect act, mid, passive:
$pft_indic_ending$ = <w_regular> ( \
    a<1st><sg><pft><indic><act><u>w_indicative\.43</u> |\
    as<2nd><sg><pft><indic><act><u>w_indicative\.44</u> |\
    e<3rd><sg><pft><indic><act><u>w_indicative\.45</u> |\
    amen<1st><pl><pft><indic><act><u>w_indicative\.46</u> |\
    ate<2nd><pl><pft><indic><act><u>w_indicative\.47</u> |\
    asi<3rd><pl><pft><indic><act><u>w_indicative\.48</u> |\
    \
    mai<1st><sg><pft><indic>[<mid><pass>]<u>w_indicative\.49</u> |\
    sai<2nd><sg><pft><indic>[<mid><pass>]<u>w_indicative\.50</u> |\
    tai<3rd><sg><pft>indic>[<mid><pass>]<u>w_indicative\.51</u> |\
    meqa<1st><pl><pft><indic>[<mid><pass>]<u>w_indicative\.52</u> |\
    sqe<2nd><pl><pft><indic>[<mid><pass>]<u>w_indicative\.53</u> |\
    ntai<3rd><pl><pft><indic>[<mid><pass>]<u>w_indicative\.54</u>  \
    \
)


% Pluperfect act, mid, passive:
$plupft_indic_ending$ = <w_regular> ( \
  h<1st><sg><plupft><indic><act><u>w_indicative\.55</u> |\
  hs<2nd><sg><plupft><indic><act><u>w_indicative\.56</u> |\
  ei<3rd><sg><plupft><indic><act><u>w_indicative\.57</u> |\
  emen<1st><pl><plupft><indic><act><u>w_indicative\.58</u> |\
  ete<2nd><pl><plupft><indic><act><u>w_indicative\.59</u> |\
  esan<3rd><pl><plupft><indic><act><u>w_indicative\.60</u> |\
  \
  mhn<1st><sg><plupft><indic>[<mid><pass>]<u>w_indicative\.61</u> |\
  so<2nd><sg><plupft><indic>[<mid><pass>]<u>w_indicative\.62</u> |\
  to<3rd><sg><plupft><indic>[<mid><pass>]<u>w_indicative\.63</u> |\
  meqa<1st><pl><plupft><indic>[<mid><pass>]<u>w_indicative\.64</u> |\
  sqe<2nd><pl><plupft><indic>[<mid><pass>]<u>w_indicative\.65</u> |\
  nto<3rd><pl><plupft><indic>[<mid><pass>]<u>w_indicative\.66</u> \
)

$w_indicative$ = ( $w_presfut_indic_ending$ | $w_imperfect_ending$ | $aor1_indic_ending$ | $pft_indic_ending$ | $plupft_indic_ending$)


$w_indicative$

% imperative.fst
% Inflectional patterns for imperative mood of regular omega verbs
%
% See Smyth #697 on perf. imptv?
%

% Present imperative endings:
$w_pres_imptv_ending$ = <w_regular> ( \
    e<2nd><sg><pres><imptv><act> |\
    etw<3rd><sg><pres><imptv><act> |\
    ete<2nd><pl><pres><imptv><act> |\
    ontwn<3rd><pl><pres><imptv><act> |\
    \
    ou<2nd><sg><pres><imptv>[<mid><pass>] |\
    esqw<3rd><sg><pres><imptv>[<mid><pass>] |\
    esqe<2nd><pl><pres><imptv>[<mid><pass>] |\
    esqwn<3rd><pl><pres><imptv>[<mid><pass>] \
    \
)

% Aorist imperative endings
$w_aor_imptv_ending$ = <w_regular> ( \
    on<2nd><sg><aor><imptv><act> |\
    atw<3rd><sg><aor><imptv><act> |\
    ate<2nd><pl><aor><imptv><act> |\
    antwn<3rd><pl><aor><imptv><act> |\
    \
    ai<2nd><sg><aor><imptv><mid> |\
    asqw<3rd><sg><aor><imptv><mid> |\
    asqe<2nd><pl><aor><imptv><mid> |\
    asqwn<3rd><pl><aor><imptv><mid> |\
    \
    hti<2nd><sg><aor><imptv><pass> |\
    htw<3rd><sg><aor><imptv><pass> |\
    hte<2nd><pl><aor><imptv><pass> |\
    entwn<3rd><pl><aor><imptv><pass> \
    \
)

% Perfect imperative endings
$w_pft_imptv_ending$ = <w_regular> ( \
    e<2nd><sg><pft><imptv><act> |\
    etw<3rd><sg><pft><imptv><act> |\
    ete<2nd><pl><pft><imptv><act> |\
    \
    so<2nd><sg><pft><imptv>[<mid><pass>] |\
    sqw<3rd><sg><pft><imptv>[<mid><pass>] |\
    sqe<2nd><pl><pft><imptv>[<mid><pass>] |\
    sqwn<3rd><pl><pft><imptv>[<mid><pass>] \
    \
)

$w_imperative$ = ($w_pres_imptv_ending$ | $w_aor_imptv_ending$ | $w_pft_imptv_ending$ )


$w_imperative$

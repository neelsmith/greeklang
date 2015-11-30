% imperative.fst
% Inflectional patterns for imperative mood of regular omega verbs
%
% See Smyth #697 on perf. imptv?
%

% Present imperative endings:
$w_pres_imptv_ending$ = <w_regular> ( \
    <w_imperative.1>e<2nd><sg><pres><imptv><act> |\
    <w_imperative.2>etw<3rd><sg><pres><imptv><act> |\
    <w_imperative.3>ete<2nd><pl><pres><imptv><act> |\
    <w_imperative.4>ontwn<3rd><pl><pres><imptv><act> |\
    \
    <w_imperative.5>ou<2nd><sg><pres><imptv>[<mid><pass>] |\
    <w_imperative.6>esqw<3rd><sg><pres><imptv>[<mid><pass>] |\
    <w_imperative.7>esqe<2nd><pl><pres><imptv>[<mid><pass>] |\
    <w_imperative.8>esqwn<3rd><pl><pres><imptv>[<mid><pass>] \
    \
)

% Aorist imperative endings
$w_aor_imptv_ending$ = <w_regular> ( \
    <w_imperative.1>on<2nd><sg><aor><imptv><act> |\
    <w_imperative.2>atw<3rd><sg><aor><imptv><act> |\
    <w_imperative.3>ate<2nd><pl><aor><imptv><act> |\
    <w_imperative.4>antwn<3rd><pl><aor><imptv><act> |\
    \
    <w_imperative.5>ai<2nd><sg><aor><imptv><mid> |\
    <w_imperative.6>asqw<3rd><sg><aor><imptv><mid> |\
    <w_imperative.7>asqe<2nd><pl><aor><imptv><mid> |\
    <w_imperative.8>asqwn<3rd><pl><aor><imptv><mid> |\
    \
    <w_imperative.9>hti<2nd><sg><aor><imptv><pass> |\
    <w_imperative.10>htw<3rd><sg><aor><imptv><pass> |\
    <w_imperative.11>hte<2nd><pl><aor><imptv><pass> |\
    <w_imperative.12>entwn<3rd><pl><aor><imptv><pass> \
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

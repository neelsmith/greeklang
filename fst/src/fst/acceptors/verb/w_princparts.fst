% w_princparts.fst
% A transducer to generate principal part stems for inflected forms of w_regular verbs.
%
% The 1st principal part is passed through unchanged since the lexicon already has
% the correct stem for it.  The transducer filters the analysis by appropriate
% tense/voice combinations to determine which principal part applies, and
% modifies the stem accordingly.
%

"<@workdir@acceptors/verb/2nd_3rd_pp.a>"

% Final transducer. (NB: leaves stem untouched for 1st principal part.)
%$2nd_3rd_pp$ || $4th_5th_pp$  || $6th_pp$

% w_princparts.fst
% A transducer to generate principal part stems for inflected forms of w_regular verbs.
%
% The 1st principal part is passed through unchanged since the lexicon already has
% the correct stem for it.  The transducer filters the analysis by appropriate
% tense/voice combinations to determine which principal part applies, and
% modifies the stem accordingly.
%

"<@workdir@acceptors/verb/w_2_3_6pp.a>" %%|| "<@workdir@acceptors/verb/6th_pp.a>" || "<@workdir@acceptors/verb/4th_5th_pp.a>"

% w_princparts.fst
% A transducer to generate principal part stems for infinitive forms of
% w_regular verbs.
%
% The 1st principal part is passed through unchanged since the lexicon already has
% the correct stem for it.  The transducer filters the analysis by appropriate
% tense/voice combinations to determine which principal part applies, and
% modifies the stem accordingly.
%

"<@workdir@acceptors/infinitive/infin_2nd-3rd.a>" || "<@workdir@acceptors/infinitive/infin_4th-5th.a>" || "<@workdir@acceptors/infinitive/infin_6th.a>"

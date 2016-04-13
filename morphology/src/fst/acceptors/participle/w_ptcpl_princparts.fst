% w_princparts.fst
% A transducer to generate principal part stems for inflected forms of w_regular participles.
%
% The 1st principal part is passed through unchanged since the lexicon already has
% the correct stem for it.  The transducer filters the analysis by appropriate
% tense/voice combinations to determine which principal part applies, and
% modifies the stem accordingly.
%


"<@workdir@acceptors/participle/w_2_3_6pp.a>" || "<@workdir@acceptors/participle/w_4_5pp.a>"  || "<@workdir@acceptors/participle/m_5pp.a>"   || "<@workdir@acceptors/participle/gm_5pp.a>"  || "<@workdir@acceptors/participle/ew_2_3_6pp.a>"  || "<@workdir@acceptors/participle/ew_4_5pp.a>" 

% "<@workdir@acceptors/participle/w_2_3_6pp.a>" || "<@workdir@acceptors/participle/aw_2_3_6pp.a>" || "<@workdir@acceptors/participle/ew_2_3_6pp.a>" || "<@workdir@acceptors/participle/ow_2_3_6pp.a>" || "<@workdir@acceptors/participle/long_aw_2_3_6pp.a>" || "<@workdir@acceptors/participle/w_4_5pp.a>" || "<@workdir@acceptors/participle/aw_4_5pp.a>" || "<@workdir@acceptors/participle/ew_4_5pp.a>" || "<@workdir@acceptors/participle/ow_4_5pp.a>" || "<@workdir@acceptors/participle/long_aw_4_5pp.a>"

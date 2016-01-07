@workdir@greek.a: @makelexica@ @workdir@symbols.fst @workdir@symbols/phonology.fst @workdir@core_inflection/inflection.a @workdir@acceptor.a @workdir@striptags.a @workdir@stripacc.a @extramakerules@
@workdir@acceptor.a: @workdir@acceptors/noun.a @workdir@acceptors/verb.a @workdir@acceptors/verbaladj.a @workdir@acceptors/infinitive.a @workdir@acceptors/indeclinable.a @workdir@acceptors/adjective.a @workdir@acceptors/adverb.a @workdir@acceptors/participle.a
@workdir@acceptors/infinitive.a: @workdir@acceptors/infinitive/w_infin_princparts.a
@workdir@acceptors/infinitive/w_infin_princparts.a: @workdir@acceptors/infinitive/infin_4th-5th.a @workdir@acceptors/infinitive/infin_2nd-3rd.a @workdir@acceptors/infinitive/infin_6th.a
@workdir@acceptors/infinitive/infin_4th-5th.a: @workdir@acceptors/infinitive/infin_kappa.a @workdir@acceptors/infinitive/infin_redup.a
@workdir@acceptors/verb.a: @workdir@acceptors/verb/w_princparts.a @workdir@acceptors/verb/augment.a
@workdir@acceptors/verb/w_princparts.a: @workdir@acceptors/verb/2nd_3rd_pp.a @workdir@acceptors/verb/4th_5th_pp.a @workdir@acceptors/verb/6th_pp.a
@workdir@utils/rawaccepted.a: @makelexica@ @workdir@symbols.fst @workdir@extratags.fst @workdir@symbols/phonology.fst @workdir@core_inflection/inflection.a @workdir@acceptor.a @workdir@striptags.a @extramakerules@
%.a: %.fst
	fst-compiler $< $@

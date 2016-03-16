@workdir@greek.a: @workdir@symbols.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@acceptor.a @workdir@generator.a
@workdir@acceptor.a:  @workdir@acceptors/verb.a @workdir@acceptors/infinitive.a  @workdir@acceptors/participle.a
@workdir@acceptors/infinitive.a: @workdir@acceptors/infinitive/w_infin_princparts.a
@workdir@acceptors/infinitive/w_infin_princparts.a: @workdir@acceptors/infinitive/infin_4th-5th.a @workdir@acceptors/infinitive/infin_2nd-3rd.a @workdir@acceptors/infinitive/infin_6th.a
@workdir@acceptors/infinitive/infin_4th-5th.a: @workdir@acceptors/infinitive/infin_kappa.a @workdir@acceptors/infinitive/infin_redup.a
@workdir@acceptors/verb.a: @workdir@acceptors/verb/w_princparts.a @workdir@acceptors/verb/augment.a
@workdir@acceptors/verb/w_princparts.a: @workdir@acceptors/verb/2nd_3rd_pp.a @workdir@acceptors/verb/4th_5th_pp.a @workdir@acceptors/verb/6th_pp.a
@workdir@generator.a: @workdir@symbols.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@generators/noungen.a
@workdir@utils/rawaccepted.a: @workdir@symbols.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@acceptor.a
%.a: %.fst
	fst-compiler $< $@

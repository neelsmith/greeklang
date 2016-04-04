@workdir@greek.a: @workdir@symbols.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@acceptor.a @workdir@generator.a
@workdir@acceptor.a:  @workdir@acceptors/verb.a @workdir@acceptors/infinitive.a  @workdir@acceptors/participle.a
@workdir@acceptors/infinitive.a: @workdir@acceptors/infinitive/w_infin_princparts.a
@workdir@acceptors/infinitive/w_infin_princparts.a: @workdir@acceptors/infinitive/infin_2nd-3rd.a  @workdir@acceptors/infinitive/infin_4th-5th.a  @workdir@acceptors/infinitive/infin_6th.a
@workdir@acceptors/infinitive/infin_4th-5th.a: @workdir@acceptors/infinitive/infin_kappa.a @workdir@acceptors/infinitive/infin_redup.a
@workdir@acceptors/verb.a: @workdir@acceptors/verb/w_princparts.a @workdir@acceptors/verb/augment.a
@workdir@acceptors/verb/w_princparts.a: @workdir@acceptors/verb/w_2_3_6pp.a @workdir@acceptors/verb/ew_2_3_6pp.a @workdir@acceptors/verb/aw_2_3_6pp.a @workdir@acceptors/verb/long_aw_2_3_6pp.a @workdir@acceptors/verb/ow_2_3_6pp.a @workdir@acceptors/verb/w_4_5pp.a
@workdir@generator.a: @workdir@symbols.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@generators/noungen.a
@workdir@utils/rawaccepted.a: @workdir@symbols.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@acceptor.a
%.a: %.fst
	fst-compiler $< $@

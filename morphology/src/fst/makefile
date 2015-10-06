@workdir@morphology.a: @makelexica@ @workdir@symbols.fst @workdir@extratags.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@acceptor.a @workdir@striptags.a @extramakerules@
@workdir@acceptor.a: @workdir@acceptors/noun.a @workdir@acceptors/verb.a @workdir@acceptors/verbaladj.a @workdir@acceptors/infinitive.a
@workdir@acceptors/infinitive.a: @workdir@acceptors/infinitive/w_infin_princparts.a
@workdir@acceptors/infinitive/w_infin_princparts.a: @workdir@acceptors/infinitive/infin_4th-5th.a @workdir@acceptors/infinitive/infin_2nd-3rd.a @workdir@acceptors/infinitive/infin_6th.a
@workdir@acceptors/infinitive/infin_4th-5th.a: @workdir@acceptors/infinitive/infin_kappa.a @workdir@acceptors/infinitive/infin_redup.a
@workdir@acceptors/verb.a: @workdir@acceptors/verb/w_princparts.a @workdir@acceptors/verb/augment.a
@workdir@acceptors/verb/w_princparts.a: @workdir@acceptors/verb/2nd_3rd_pp.a
@workdir@inflection.a: @workdir@inflection/nouninfl.a @workdir@inflection/verbinfl.a  @workdir@inflection/vadjinfl.a @workdir@inflection/infininfl.a
@workdir@inflection/verbinfl.a:  @workdir@inflection/w_regular_infl.a
@workdir@inflection/w_regular_infl.a: @workdir@inflection/w_regular/indicative.a  @workdir@inflection/w_regular/subjunctive.a  @workdir@inflection/w_regular/optative.a  @workdir@inflection/w_regular/imperative.a
%.a: %.fst
	fst-compiler $< $@

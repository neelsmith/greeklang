@workdir@morphology.a: @makelexica@ @workdir@symbols.fst @workdir@extratags.fst @workdir@symbols/phonology.fst @workdir@inflection.a @workdir@acceptor.a @extramakerules@
@workdir@acceptor.a: @workdir@acceptors/noun.a @workdir@acceptors/verb.a
@workdir@verb.a: @workdir@acceptors/w_princparts.a @workdir@acceptors/augment.a
@workdir@inflection.a: @workdir@inflection/nouninfl.a @workdir@inflection/verbinfl.a
@workdir@inflection/verbinfl.a:  @workdir@inflection/w_regular_infl.a
%.a: %.fst
	fst-compiler $< $@

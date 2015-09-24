@workdir@morphology.a: @workdir@symbols.fst @workdir@extratags.fst @workdir@phonology.fst @workdir@lexicon.fst @workdir@iliad.fst @workdir@inflection.a @workdir@extrainfl.a @workdir@acceptor.a
@workdir@acceptor.a: @workdir@stemtypes.fst
%.a: %.fst
	fst-compiler $< $@

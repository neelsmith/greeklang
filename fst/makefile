morphology.a: symbols.fst extratags.fst phonology.fst lexicon.fst inflection.a extrainfl.a acceptor.a
acceptor.a: stemtypes.fst
%.a: %.fst
	fst-compiler $< $@

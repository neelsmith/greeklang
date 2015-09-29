@workdir@morphology.a: @makelexica@ @workdir@morphsymbols.fst @workdir@extratags.fst @workdir@phonology.fst @workdir@inflection.a @workdir@extrainfl.a @workdir@acceptor.a
@workdir@acceptor.a: @workdir@acceptors/noun.a @workdir@acceptors/verb.a
@workdir@inflection.a: @workdir@inflection/nouninfl.a @workdir@inflection/verbinfl.a
%.a: %.fst
	fst-compiler $< $@

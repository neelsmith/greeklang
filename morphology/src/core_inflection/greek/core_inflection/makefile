@workdir@core_inflection/inflection.a: @workdir@core_inflection/inflection/nouninfl.a @workdir@core_inflection/inflection/irregnoun.a @workdir@core_inflection/inflection/verbinfl.a  @workdir@core_inflection/inflection/vadjinfl.a @workdir@core_inflection/inflection/infininfl.a
@workdir@core_inflection/inflection/verbinfl.a:  @workdir@core_inflection/inflection/w_regular_infl.a
@workdir@core_inflection/inflection/w_regular_infl.a: @workdir@core_inflection/inflection/w_regular/indicative.a  @workdir@core_inflection/inflection/w_regular/subjunctive.a  @workdir@core_inflection/inflection/w_regular/optative.a  @workdir@core_inflection/inflection/w_regular/imperative.a
%.a: %.fst
	fst-compiler $< $@

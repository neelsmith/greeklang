% verbanalysis.fst

#include "../../build/fst/symbols.fst"

$verbanalysis$ = [#urn#]+[#stemchars#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#urn#][#letter#]*[#person#][#number#][#tense#][#mood#][#voice#][#extratag#]*


$verbanalysis$

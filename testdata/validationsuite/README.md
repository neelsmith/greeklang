# `jmorph` validation suite #

In the subdirectory `generator`, a series of `.csv` files define tests in six columns:

1. lemma, a label used only to help humans interpret test results
2. a CITE URN for the lexical entity labelled by lemma
3. a morphological form to generate,  specified as a colon-delimited, nine-column value that forms a valid complete form specification when submitted to the MorphForm class
4. a (possibly empty) list of tags used to filter (i.e., limit) the generated output
5. a comma-separated list of resulting forms in beta code
6. the same list of resulting forms in UTF-8

A request to generate a specified  form (column 3) for a specified lexical entity (column 2), with results limited by tags (column 4) should produce the list of forms given in column 5.
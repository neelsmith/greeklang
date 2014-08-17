## Identifying Greek lexical entities ##

`lexent.db` is a sqlite database with canonical identifiers for more than 127,000 Greek lexical entities.  The canonical identifiers are CITE Collection URNs in the `perseus` namespace (*full form?*). The database has a lemma form for each entity, and for most entries includes a short definition.

SOURCE:  downloaded from Google table : <https://www.google.com/fusiontables/DataSource?docid=1ftJ-hXUv4XyEEu_vdpKKJQKyvoVbUTMA2izEhFM>

MODIFIED:  lemma forms normalized.  Short defs cleaned so they parse with OpenCSV.  `rejected` forms omitted.

BUILD YOUR APP:   in sqlite, lemma form is UTF-8, precombined.  Be careful if you want people to search from interactively composed input.


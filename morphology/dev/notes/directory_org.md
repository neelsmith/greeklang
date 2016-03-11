# Directory organization

Within a gradle ${projectDir}:

- All data for compilation: **${datadir}**
    - Per orthography: **${orthography}**
        - orthography
            - symbols
                - alphabet.fst
        - stems-csv
            - adjectives
            - indeclinables
            - nouns
            - other
            - verbs-compound
            - verbs-simplex
        - rules-csv
            - adjectiveinfl.fst
            - adverbinfl.fst
            - indeclinfl.fst
            - infininfl.fst
            - nouninfl.fst
            - ptcplinfl.fst
            - vadjinfl.fst
            - verbinfl.fst

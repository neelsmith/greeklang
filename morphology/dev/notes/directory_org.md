# Directory organization

Within a gradle ${projectDir}:

- All data for compilation: **${datadir}**
    - Per orthography: **${orthography}**
        - stems-csv
            - adjectives
            - indeclinables
            - nouns
            - other
            - verbs-compound
            - verbs-simplex
        - stems-fst: THIS SHOULD BE BUILT NOW!
        - rules-csv
        - rules-fst

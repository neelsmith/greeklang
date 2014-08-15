## How to add new vocabulary items ##


1. add one or more stems to the MorphologicalStems database in `morphstems.csv`.  If this is an entirely new vocabulary item unknown to LSJ/Perseus, you will need to follow a convention to ensure that you can safely generate unique URNs for the lexical entity.
2. for each stem you add, add one or more tags to `tags.csv`.   If you are adding new vocabulary (whether new to LSJ/Perseus, or just new to the lexicon you're using), these may simply be tagged as `standard` for normal literary Greek.  If these are new forms for existing words, you may want to use one of these other tags currently recognized by the parser:
    - `epic` for forms occurring in epic poetry
    - `attic` for distinctly Attic forms of literary Greek (e.g, -ττ- for -σσ-)
    - `ionic` for distinctly Ionic forms of literary Greek (e.g., η following ε, ι, ρ)

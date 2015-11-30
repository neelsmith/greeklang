
# core inflectional patterns


Move into a distinct source directory and break out by *orthographic system*.

- `greek` = literary Greek, as in print editions
- `attic` = Attic alphabet used before archonship of Euclid in 403.

To any core system, add supplementary rules in `data/rules-fst`

Be sure that lexica of stems use same orthographic system or you will get nonsense.


## How to integrate common parts?

Vary by orthographic system:

- `inflection.fst` (and associated subdir)
- `symbols/phonology.fst`

`makefile` has to take account of these

Constant across orthographic systems:

- everything else?

.wq

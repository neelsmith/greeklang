
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



## Dependencies




- `inflection.a` is used in `greek.fst`, so need a separately compiled inflection module
- `phonology.fst` is included in `symbols.fst`
- acceptors use letter definitions from `phonology.fst`:



    % Characters for Greek character set:
    #consonant# = bgdzqklmncprstfxy
    #vowel# = aeiouhw\|
    #breathing# = <sm><ro>
    #letter# = #consonant# #vowel# #breathing#


So break out an "alphabet" file to include in phonology

So requirements would be;

1. makefile compiling `inflection.a`
2. cp in compiled inflection.a and its source files (for inclusion in symbols)
3. √ cp in alphabet file (alphabet.fst?)

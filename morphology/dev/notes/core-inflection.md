
# core inflectional patterns


Move into a distinct source directory and break out by *orthographic system*.

- `greek` = literary Greek, as in print editions
- `attic` = Attic alphabet used before archonship of Euclid in 403.

To any core system, add supplementary rules in `data/rules-fst`

Be sure that lexica of stems use same orthographic system or you will get nonsense.



## Dependencies for FST compilation

Vary by orthographic system:

- `inflection.fst` (and associated subdir)
- `symbols/phonology.fst`


**ADD AUGMENT TO THIS LIST!** See issue #189

`makefile` has to take account of these




- `inflection.a` is used in `greek.fst`, so need a separately compiled inflection module
- `phonology.fst` is included in `symbols.fst`
- acceptors use letter definitions from `phonology.fst`:
    - `AnalysisTriple`
    - `FstToken`

Break out an "alphabet" file to include in phonology


    % Characters for Greek character set:
    #consonant# = bgdzqklmncprstfxy
    #vowel# = aeiouhw\|
    #breathing# = <sm><ro>
    #letter# = #consonant# #vowel# #breathing#



So requirements would be;

1. √ makefile compiling `inflection.a`
2. √ cp in compiled inflection.a and its source files (for inclusion in symbols)
3. √ cp in alphabet file (alphabet.fst?)


## Dependencies for JVM code

UPDATE THIS LIST FOR DOCS:  instead of list below, either

- use `GreekOrthography` interface, or
- use ortho-specific class (e.g., `AtticParser`)


These classes use `GreekString` objects:

- `AnalysisTriple`
- `FstToken`
- `MorphologicalAnalysis`
- `MorphologicalParser`


.wq

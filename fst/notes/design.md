
## Other

- Need to map morpheus stem classes/tenses (inflectionl patterns) to Smyth references



## extratags design

Data:

- 2 directories of dynamically loaded files:  one defining stems, and one implementing inflectional rules.  The directories should be configurable
- single list of additional tags

Process:

- automatically extract list of URNs from stems
- best practice:  every lexicon is identified by some user-defined stem, e.g., <ml> for middle Liddell
- acceptors allow optional inclusion of additional tags


## augment

- mark location in lexicon, eg. <aug>lu<verb>
- classify tense/mood combos as "augmented" "unaugmented"
- define transforamtion of <aug> -> e with appropriate neighboring modifications:
    - add breathing if initial
    - drop preceding vowel
    - compound!


## princ.parts

- filter on #classtem# tag:  separate transducers for regular formations:
    - w_regular
    - [aeo]_contract
    - (possibly -mi classses: to be investigated)
- other classtems must give all principal parts, normally 6, or possibly 4 for deponents.  Note that deponency is not a morphological feature: absence of principal parts is just a question of usage/attestation that might reflect in some cases the semantic and syntactic phenomenon of deponency

## accent

- gradle build takes list of words (configurable: default `wordlist.txt`), cps to buidl area
- strip accent, write list of stripped words to build area
- run FST on stripped list
- parse FST output:
    - record FST failures
    - from analysis, add accent to stripped form, cf to source string

## lexicon

- look at how Harry parses :le: lists from morpheus
- map lexicon entries to URN values in .csv file

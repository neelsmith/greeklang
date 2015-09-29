



## extratags design

Data:

- 2 directories of dynamically loaded files:  one defining stems, and one implementing inflectional rules.  The directories should be configurable
- single list of additional tags

Process:

- automatically extract list of URNs from stems
- every lexicon should be identified by some user-defined stem, e.g., &lt;ml> for middle Liddell.  Enforce this by requiring *some* extratag to be included in lex stem
- *best practice recommendation*:  any additional inflectional patterns should also be tagged.  Not explicitly enforced, however.
- Need to map morpheus stem classes/tenses (inflectionl patterns) to Smyth references
- acceptors allow optional inclusion of additional tags



## verb pipeline


### princ.parts

- first step in verb pipeline
- filter on #classtem# tag:  separate transducers for regular formations:
    - w_regular
    - [aeo]_contract
    - (possibly -mi classses: to be investigated)
-
- other classtems must give all principal parts, normally 6, or possibly 4 for deponents.  Note that deponency is not a morphological feature: absence of principal parts is just a question of usage/attestation that might reflect in some cases the semantic and syntactic phenomenon of deponency.  A single transducer should simply classify 1st-6thpp stems and use thoses values.


### augment

- follows princ. parts in verb pipeline
- mark location in lexicon, eg. <aug>lu<verb>
- classify tense/mood combos as "augmented" "unaugmented"
- define transforamtion of <aug> -> e with appropriate neighboring modifications:
    - add breathing if initial
    - drop preceding vowel
    - compound!

## accent

- gradle build takes list of words (configurable: default `wordlist.txt`), cps to buidl area
- strip accent, write list of stripped words to build area
- run FST on stripped list
- parse FST output:
    - record FST failures
    - from analysis, add accent to stripped form, cf to source string

## lexicon

- map lexicon entries to URN values in .csv file in extracting entries from morpheus source
- use .csv white boards to check off progress
- use HMT project vocab lists to drive development of inflectional patterns for real corpora:
   - *Iliad*
   - scholia
   - other texts


## unifying and integrating data

- URNs for lexical entities drawn from external lex.ent. source
- generate URNs for stems, with one collection per "lexicon".  Since each lexicon has a lex.ent. URN, we have mapped stems to lexical entities.
- generate URNs for inflectional patterns:  at what level is collection and object?  Might be sensible to include URN per transducer and output that along with stem class.  Or is stem class enough?
- could we put smyth references on transducers as optional tags?

## Managing URNs in greekmorph

- in SFST strings, URNs are abbreviated to <Coll.Obj>
- collection names must be unique within the parser
- collection names must be registered with UrnManager


## SFST

URNs are symbols in the SFT alphabet, so must be available there in character classes

- URNs for lexical stems must have their **collection registered with the UrnManager**
- URNs for core inflectional patterns are harvested from `collectionAbbreviations.csv`
- URNs for further inflectional patterns must have their **collection registered with the UrnManager**
- URNs for (optional) taxonomic tags listed in `.[ct]sv` files in `tagsdir` must have their **collection registered with the UrnManager**

Which individual values need to be gathered?

- lexent collection is **harvested from tables in stems-lexica??** or **directly from  .fst??**
- in some fashion, URNs for individual inflectional patterns must be harvested!


Other observations
%
% The FST system works with 4 kinds of URNs:
% To parse the FST analysis string, we need to be able to recognize 3 of the 4 kinds of
% URNs as classes we group in FST variables.
%
% For morphological categories, we're only ever working with individual values or
% sets of values we construct on the fly, I think.
%
% We also work with URNs for forms, but these are deterministcally generated on the fly
% when the FST analysis string is parsed, and not part of the FST analysis string.
%
%


%
 %
 % FURTHER URNS USED IN THE SYSTEM
 %
 % Morphological categories.  Collection to expand this to full URN already registered
 % since these are known values.
 %
 % Thus: lexical entities + lexicon of stems + inflectional pattern all in

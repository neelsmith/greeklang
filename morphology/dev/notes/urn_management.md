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

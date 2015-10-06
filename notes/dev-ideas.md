
# morphology and Greek lang. work

## Accents: joining MorphAnalysis object to FST

- either of morph stem or inflectional pattern can carry accent tag
- (in case of ending, if appropriate, encode accent directly?)
- MorphAnalysis object needs to read from and serialize to FST format
- MorphAnalysis object should collect *all* optional tags
- MorphAnalysis object should collect *all* accent tags
- MorphAnalysis object should be able either to strip or add accents

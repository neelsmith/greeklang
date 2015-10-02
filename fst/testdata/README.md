# Adding your own tests


1. Compile the analyzer with your data:
    - put one or more stem lexica in `fst/testdata/stems`
    - if you want to include added inflectional rules in your test, be sure you have added them to `fst/rules`
2. - in `wordlists`, add lists of Greek words to analyze in UTF-8 character encoding.
3. Run `gradle analyzeTests`

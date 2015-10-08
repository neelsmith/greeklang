# Overview of parsing by the `MorphologicalParser` class

The `MorphologicalParser` class is a morphological black box with methods for parsing `GreekString` objects (individually, or in lists).  These parsing methods return a `MorphologicalAnalysis` for each token: objects of the `MorphologicalAnalysis` class are composed of the `GreekString` and a list of zero or more `MorphForm`s.  `MorphForm`s in turn have an `AnalyticalType`, and a corresponding `CitableForm`.  (In this system there are something like 9 implementations of `CitableForm`.)


Internally, the `MorphologicalParser` uses an `FstParser` object to manage a FST parsing engine.
The FST parsing engine operates on `FstTokens`, which can be constructed from `GreekStrings`.

The output of the FST engine is just structured text.  The `MorphologicalParser` uses a `FstAnalysisParser` to work with this text, and convert it to `MorphForm` objects.

The `MorphologicalParser` collects a list of these `MorphForm` objects, and passes together with the original `GreekString` to create the final `MorphologicalAnalysis` for a parse.

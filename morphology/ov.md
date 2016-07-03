---
title: "Using Kanōnes: a brief overview"
layout: page
---

## Building a parser

Compile a parser with two gradle tasks:

1. `gradle buildStems`
2. `gradle fst`

The `buildStems` task reads in simple delimited text files with your data for stem dictionaries and for inflectional rules, and translates them into SFST-PL, the language of the Stuttgart FST toolkit. Optionally, use the `datadir` to specify a directory where you store your data tables, e.g., `gradle -Pdatadir`. The default value is the `sampledata` directory in the distribution.  Within `datadir`, you should have one or more subdirectories with a complete set of tables for a given corpus.  You may choose which one to use with the `dataset` property.  `gradle -Pdataset=smyth buildStems` will translate the tables in the `smyth` directory within the default source directory (`sampledata`).

The `fst` task compiles a binary parser.  The output is written in the `build` directory, in a subdirectory named for the current set.  You can easily compile multiple distinct parsers.  The following two lines illustrate this:

    gradle -Pdataset=smyth buildStems && gradle -Pdataset=smyth fst
    gradle -Pdataset=attic buildStems && gradle -Pdataset=attic fst

Both lines use the default source directory (since no `datadir` property was specified).  The first line compiles a parser for the `smyth` corpus in `build/smyth`, while the second line compiles a parser for the `attic` corpus in `build/attic`.  The binary parser in each case will be named `greek.a`


## Using a parser

The compiled parser can be used in multiple ways.  You can work directly with the utility programs of SFST toolkit, such as `fst-mor`.   (See [SFST documentation](http://www.cis.uni-muenchen.de/~schmid/tools/SFST/) for information.)  For example,  run `fst-mor build/smyth/greek.a` to enter forms interactively for analysis.  Note, however, that the FST works on *unaccented* forms.

You can also parse fully accented forms in a simple text file with one word per line using the included `greek.sh` shell script.  It writes to standard output, so redirect it if you want to save to a file, e.g., `greek.sh WORDSTOPARSE.txt > analyses.txt` to save analyses of `WORDSTOPARSE.txt` in `analyses.txt`.

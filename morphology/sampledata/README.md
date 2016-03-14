# Sample data sets

Each subdirectory contains a complete data set for building a parser. You can build a parser from any of the data sets by setting the `datadir` property to the name of this directory, and the `dataset` property to the name of one of the subdirectories.  The morphology project's `scripts` directory has shell scripts that offer a simplified way to call the appropriate gradle tasks while setting the property values on the command line.

The data sets planned for inclusion here in the 1.0 release of Kanōnes are:

| Data set | Orthography                      | Description                                                                                                         |
|:---------|:---------------------------------|:--------------------------------------------------------------------------------------------------------------------|
| smyth    | Standard literary Greek          | Rules and stems cover all paradigms in Smith, *Greek Grammar*                                                       |
| pool     | Standard literary Greek          | A whole lot of stuff quarried from Perseus data sources. God only knows what might be in here. It's definitely big. |
| lysias1  | Standard literary Greek          | Complete rules and vocabulary covering an edition of Lysias, *Against Eratosthenes*.                                |
| attic    | Attic orthography before 403 BCE | Contents of a single inscription, to be determined.                                                                 |

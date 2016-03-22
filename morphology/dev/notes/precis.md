# Precis

Kanōnes is a system for building morphological parsers for a corpus of texts in Greek.

## Two components for "analysis by synthesis"

Kanōnes works at two levels:

1. a finite state transducer that produces analyses for unaccented Greek strings
2. a JVM class that works with accented Greek

The JVM class accepts accented Greek strings, strips them of their accent, and collects analyses from the FST for the unaccented form.  The JVM class then adds the specific accent appropriate for each analaysis, and compares the result to see if it equals the originally submitted form.




## Building a parser

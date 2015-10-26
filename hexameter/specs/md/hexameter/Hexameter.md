# Hexameter

## Design of library

API for I/O should follow pattern of morphology package.



Input:  text content of a single hexameter, either of

- a GreekString (using GreekString class to get a list of GreekWord tokens)
- a list of GreekWord tokens

Or text content of a list of hexameters, either of

- a list of GreekString objects
- a list of lists of GreekWord tokens



Output structure for a single hexameter:

- a single Hexameter object


The Hexameter object has an ordered list of six Foot objects.

Each Foot object has

- string
- a FootMeter object



The Foot object has methods that in turn can resolve the foot's string to syllables and foot's FootMeter to SyllableMeter objects and align them.

So we have three levels of alignment:

1. Text content of a hexameter, represented as a GreekString or list of GreekWords -> a Hexameter object
2. Text content of a foot, represented as a String -> FootMeter (dactyl, spondee, anceps)
3. Text content of a syllable, represented as a String -> SyllableMeter (long, short, anceps)

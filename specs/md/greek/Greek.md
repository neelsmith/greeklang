# A computational system for Greek, version @version@ #

## Background and organization of this specification ##

This is the beginning of a specification for an extensive computational system for working with ancient Greek. Because ancient Greek is a historical language, its production is closed, and its scope is limited enough that entire corpora defined by genre, period or other criteria might be available in digital editions.  Parts of the system specified here will be useful for many kinds of corpus-linguistic analyses of ancient Greek texts.   One particular and immediate goal of this system is to support a systematic analysis of formulaic language in Homeric poetry that combines morphological and metrical analyses.   The second and third sections linked below therefore specify analyses of morphology and Homeric hexameter.

Of course these higher order specifications cannot be applied to arbitrary strings of characters, and in 2015 it is essential to specify unambiguously how the writing system of literary Greek is to be represented digitally since no section of the Unicode definition more thoroughly confuses the concepts of character in a writing system, glyph representing that character, and presentional variants of a glyph than the section dealing with polytonic Greek. 



## Specifications:  representing Greek texts (significant portions complete)

- Working with <a concordion:run="concordion" href="tokens/Tokens.html">strings of text, and with individual lexical, numeric and astronomical tokens</a> in the standard writing system of literary ancient Greek 

## Specifications:  morphology (**minimal content**) ##

- <a concordion:run="concordion" href="morphology/Morphology.html">Greek morphology</a>

## Specifications: syllabification and meter (**not yet begun**) ##


- <a concordion:run="concordion" href="syllables/Syllables.html">Syllabification of tokens</a>
- <a concordion:run="concordion" href="hexameter/Hexameter.html">Homeric hexameter</a>


## About these specifications##

The specification includes live tests verifying that an implementation fulfills the specification. The live tests are defined using [concordion](http://concordion.org/), so the specification can be implemented in and tested with multiple programming languages.

The specification together with an implementation in JVM languages (java and groovy) is maintained at <http://neelsmith.github.io/greeklang/>. A copy of the specification rendered with concordion to run all tests the of this implementation is included in the project web site at <http://neelsmith.github.io/greeklang/specs/greek/Greek.html>.


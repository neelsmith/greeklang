# Digital representation of Greek text

The specifications linked below define a system for representing meaningful tokens in the standard alphabetic writing system used in manuscripts and printed editions of ancient Greek texts. They do not address the problem of representing epichoric Greek alphabets, which are unknown to Unicode.

The current draft aims to specify three kinds of token:  alphabetic text, numbers written in the "Milesian" notational system, and astronomical symbols.  Because Unicode offers no way of distinguishing visually similar glyphs for Greek alphabetic and numeric values (e.g., Unicode α could represent either the alphabetic character alpha or the digit 1), the specifications assume that by some process not defined in this library's specifications, the context will determine how to treat a string as a particular type of token.  For example, the Homer Multitext project's process for tokenizing its archival editions treats strings  as lexical tokens by default, and uses strictly defined XML markup conventions   to disambiguate other token types.



## Specifications for alphabetic text


- Valid <a concordion:run="concordion" href="GreekString.html">strings of characters</a> in the orthography of standard printed editions. (**Substantially complete**)
-  Valid <a concordion:run="concordion" href="MsString.html">strings of characters</a> in the orthography found in manuscripts (**Outline only**)
- Valid <a concordion:run="concordion"  href="GreekWord.html">lexical tokens</a> ("words") in the orthography of standard printed editions (**Substantially complete**)
-  Valid <a concordion:run="concordion"  href="MsWord.html">lexical tokens</a> ("words") in the orthography found in manuscripts (**TBA**)
- <a concordion:run="concordion"  href="GreekSort.html">Alphabetic sorting and comparison</a> (**Inital phase complete**)


## Specifications for the "Milesian" numeric notation (**substantially complete**)##

The "Milesian" system of numeric notation borrowed glyphs from the alphabetic writing systems.  In addition to glyphs from familiar from the standard literary Greek alphabet, these included glyphs for 6, 90 and 900 drawn from epichoric alphabets, and lacking any corresponding character in the later literary Greek alphabet.

- <a concordion:run="concordion" href="milesian/Milesian.html">Milesian notation</a>


## Specifications for other symbolic notation  (**TBA**) ##

- Valid astronomical symbols


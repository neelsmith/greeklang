---
title: "Foundational libraries: release notes"
layout: page
---

**2.3.2** Fixes a bug in syllabification of strings with explicit marker for vowel quantity where regular expression patterns could overlap.

**2.3.1** Fixes a bug in syllabification of strings with explicit marker for vowel quantity.

**2.3.0** New functionality: additional signatures added to static methods of `Accent` class. Bug fixes in accent handling, and in syllabification of `GreekString` objects.

**2.2.3** Fixes a bug in constructing `GreekString` objects with rough breathing in Unicode representation.

**2.2.2** Fixes a bug in the `Accent` class when diphthong in final syllable should be treated as short.

**2.2.1** Fixes a bug in the `Accent` class placing accents on syllables containing an iota subscript.

**2.2.0** New functionality: serialization of `GreekNode` objects as XML.

**2.1.0** Fixes a bug in sorting `GreekString` objects where accents and breathings were being properly indexed.

**2.0.0** Changes breaking backward compatibility: new signatures to constructors for `GreekString`s in unicode.  New functionality:  `GreekString` class now implements `Comparable` interface allowing comparison based on logic of Greek alphabetic order.  `GreekNode` adds utilities for working with `GreekString` content in XML documents.

**1.1.0** New functionality:  extensively tested `Syllable` class with static methods for dividing `GreekWord` objects into syllables.

**1.0.1** Bug fixes in working with strings representing numeric values in Milesian notation.  Fractional characters for 1/2 and 2/3 do not require separating single quote character when there is no accompanying integer component.

**1.0.0** Initial release.

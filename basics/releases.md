---
title: "Foundational libraries: release notes"
layout: page
---

**2.2.0** New functionality: serialization of `GreekNode` objects as XML.

**2.1.0** Fixes a bug in sorting `GreekString` objects where accents and breathings were being properly indexed.

**2.0.0** Changes breaking backward compatibility: new signatures to constructors for `GreekString`s in unicode.  New functionality:  `GreekString` class now implements `Comparable` interface allowing comparison based on logic of Greek alphabetic order.  `GreekNode` adds utilities for working with `GreekString` content in XML documents.

**1.1.0** New functionality:  extensively tested `Syllable` class with static methods for dividing `GreekWord` objects into syllables.

**1.0.1** Bug fixes in working with strings representing numeric values in Milesian notation.  Fractional characters for 1/2 and 2/3 do not require separating single quote character when there is no accompanying integer component.

**1.0.0** Initial release.

---
title: Semantic versioning for documentation
layout: page
---


Testable specifications and implementing libraries do not always advance in parallel:  a bug fix might result in a new release of a library without any change in the specification, for example, or the specification might be clarified or corrected without requiring any accompanying change in the implementation.

Specification documents therefore always include a prominent reference to the version of the implementing library they were tested against.  The specifications themselves are identified by a three-part version number meeting the syntactic requirements of the [semantic versioning specification](http://semver.org/) in the form `MAJOR.MINOR.PATCH`.  When referring to documentation, the following logic dictates when each part is incremented:

1. `MAJOR` version when the documentation applies to a *new implementation* of the library.
2. `MINOR` version when the documentation expands coverage of an existing implementation of the library.
3. `PATCH` version when an error in the documentation is corrected.

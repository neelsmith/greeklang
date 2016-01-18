---
title: How can I evaluate these projects?
layout: page
---

In the "digital humanities," we do not yet have established practices or institutions for evaluating functioning systems:  we're still better at the "humanities" than the "digital" part of our work.  I take it as axiomatic that claims about  automated systems need to be backed by automated forms of analysis and verification. Otherwise, journal publications or conference publications describing digital work are only remote and subjective proxies.


My work on this computational system for working with ancient Greek borrows well established practices from computer science and engineering so that others can evaluate its code libraries before investing their time in using them. For each separately packaged library, I include three complementary forms of automatically generated information.

1. The system includes hundreds of unit tests.  Source code for these is in the `src/test` directory of each package.  The full suite of tests for each package can be run with the command `gradle test`.  (In the `morphology` project, see the `README` file for ensuring that the test data are properly loaded in the parser prior to testing.)
2. API documentation for each package can be generated with the command `gradle groovydoc`.  
3. Each project also includes testable formal specifications.  These specifications use the [concordion testing framework](http://concordion.org/) to unify descriptive prose and automated testing in a single document. A readable HTML version of the specifications can be generated with the command `gradle conc`:  statements that are verified by automated testing are highlighted in green.


Release versions of each package pass 100% of its unit tests and 100% of the tests in its formal specifications, so anyone depending on one of these libraries can be confident of what tests each release has passed.   The prose specification gives a high-level overview of each library; for those who want to understand the system's internal operation, API documentation and unit tests together give a detailed, tested description.

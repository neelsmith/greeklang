---
title: A computational system for ancient Greek
layout: page
---


## Approach
This web site outlines initial work on a computational system for working with texts in ancient Greek.  I am first specifying each component of the system using [concordion](http://concordion.org/)'s notation to define tests that can then be implemented in a variety of languages.  I am then implementing pieces of the system in JVM languages (Java and Groovy).

When parts of the prose specification pass all tests, I am posting here the concordion output (that is, web pages with the test results embedded in the prose of the specification), and API documentation.

## Contents ##

Components I have begun to specify so far:

- composition of strings of characters and of lexical tokens
- syllabification of lexical tokens
- morphological analysis of lexical tokens
- metrical analysis of Homeric hexameter


## Results ##


- [live specifications](specs/greek/Greek.html)
- [API docs](api)
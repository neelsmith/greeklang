# A computational system for Greek, version @version@ #

This is an early draft of a specification for an extensive computational system for working with ancient Greek. The specification includes live tests verifying that an implementation fulfills the specification. The live tests are defined using [concordion](http://concordion.org/), so the specification can be implemented in and tested with multiple programming languages.

The specification together with an implementation in JVM languages (java and groovy) is maintained at <http://neelsmith.github.io/greeklang/>. A copy of the specification rendered with concordion to run all tests the of this implementation is included at <http://neelsmith.github.io/greeklang/specs/greek/Greek.html>.


## Specifications

- Strings of <a concordion:run="concordion" href="tokens/Tokens.html">characters and lexical tokens</a>
- Syllabification of tokens
- Greek morphology
- Homeric hexameter



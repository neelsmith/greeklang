# A computational system for Greek, version @version@ #

In this documentation, you will find the early draft of a specification for an extensive computational system for working with ancient Greek. The specification includes live tests verifying that an implementation fulfills the specification. The live tests are defined using [concordion](http://concordion.org/), so the specification can be implemented in and tested with multiple programming languages.

The specification is maintained at <https://github.com/neelsmith/greeklang>, along with an implementation in JVM languages (java and groovy). A copy of the specification rendered with concordion to run all tests the of this implementation is available from <http://neelsmith.github.io/greeklang/specs/greek/Greek.html>.

## Specifications

- Strings of <a concordion:run="concordion" href="tokens/Tokens.html">characters and lexical tokens</a>
- Syllabification of tokens
- Greek morphology
- Hexameter meter


## Key to visual conventions

The specifications are defined using concordion to run automated tests. The resulting web pages are highlighted as follows:

- <span class="success">successfully completed automated tests</span>
- <span class="failure">failed tests</span>




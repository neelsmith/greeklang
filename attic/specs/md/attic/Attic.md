# A library for working with Greek in the pre-403 BCE Attic alphabet  #

**Versions**: specification version **@specversion@**, documenting version **@version@** of the `attic` library.

**Home page**: <http://neelsmith.github.io/greeklang/attic/>

**Summary**: `attic` is a JVM library for working with texts in Greek recorded in the alphabet used in Attica before 403 BCE.



## Background

The current Unicode specification does not recognize any orthographic systems for writing ancient Greek other than the Ionic alphabet that first became universally used in the Hellenistic period, and developed in medieval manuscripts into the cursive form that is the basis for the orthography of modern print editions. In order to use Unicode to represent Greek texts recorded in any of the epichoric alphabets used before the Hellenic period, it is therefore necessary to define a mapping of the alphabet onto Unicode code points.

This specification follows the logic of the `GreekOrthography` interface (in the [`edu.holycross.shot.orthography` package](http://neelsmith.github.io/greeklang/basics/api/)): it defines a representation in an ASCII-only mapping that is well suited to many kinds of machine processing, and a mapping including characters in the Greek range of Unicode with glyphs that are more familiar to human readers.



## Specifications

- <a concordion:run="concordion" href="orthography/Orthography.html">orthography</a>
- <a concordion:run="concordion" href="phonology/Phonology.html">phonology</a>

## Building a parser with gradle

Can have multiple orthographies defined.

The default orthography `greek` is for standard representation of literary Greek in the Ionic alphabet. To build a binary fst parser in `build/greek/greek.a`:

    gradle fst

The alternative orthography `attic` is for Greek in the alphabet used in Athens before 403 BCE.  To build a binary fst parser in `build/attic/greek.a`:

    gradle -Portho=attic fst


    

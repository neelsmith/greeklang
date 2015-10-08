# Build corpus-specific parsers for Greek morphology #


## Prerequisites

- A POSIX-like environment with `sh`, `echo` and `make`.
- [gradle](http://gradle.org/) (which in turn requires a Java JDK or JRE)
- [groovy](http://www.groovy-lang.org/)
- [Stuttgart FST toolbox](http://www.cis.uni-muenchen.de/~schmid/tools/SFST/).  If not installed in `/usr/bin`, edit `fstconf.grade` with the full path to `fst-compiler`.



## Quick start


1. Put one or more lexica of stems in `stems`.  E.g., `cp sampledata/stems/middle_liddell.fst stems`
2. Optionally, add additional inflectional rules to `rules`.  E.g., `cp sampledata/rules/epic.fst rules`
3. Build and install the parser: `gradle install`


## Using the parser

You can use any of the Stuttgart FST tools directly with the compiled binary in `/usr/local/morphology/greek.a`. The install task installs a shell script you can run either interactively like this:

    $ greek.sh
    > λύω
    Two analyses for λύω:
    1. conjugated verb: first person singular present indicative active
    2. conjugated verb: first person singular present subjunctive active
    >

or in batch mode `greek.sh [FILE|DIRECTORY]+`.  See the documentation for details of input and output options.

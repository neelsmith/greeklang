---
title: Why libraries for the JVM?
layout: page
---

Scholars of ancient Greek need to consider carefully how their digital work will fit into a larger ecosytem.  Time is, as Antiphon says[^plut], "the costliest expenditure;"  in a small field, the price of redundant or wasted effort is especially high.

The packages in this project are written in groovy and java, and compiled for use with the Java Virtual Machine (JVM) for several reasons. Java itself is still widely used, especially on the server side of client-server applications, and runs on essentially any kind of contemporary hardware.  JVM languages are supported by well established communities.  Their flourishing development environments offer a variety of mature systems for automated testing, building and dependency management.  These librares are compiled with [gradle](http://gradle.org/) (the build system Google chose as the offical build sytem for Android Studio). Binary releases are published to a Nexus repository, where other software can depend on them using any depdency manager that understands [maven coordinates](https://maven.apache.org).   Valuable infrastructure specificallty classicists is already in place for the JVM, too. If Hugh Cayless' [transcoder][xcoder] were the only JVM library relevant for Greek, it would be a strong argument for the JVM by itself.

 The abstraction of the JVM means that binary libraries kind be used from a variety of languages beyond java, including modern scripting languages such as [groovy](http://www.groovy-lang.org) or [clojure](http://clojure.org).  As digital humanities projects begin to look more seriously at "big data" applications, [scala](http://www.scala-lang.org) (the native language of [Apache Spark][sparkie]) is likely to assume greater importance. As it does, the value of JVM libraries will only increase since they can be directly used in scala.   In the mean time, use these libraries with the JVM language of your choice.


Programming languages are not immortal, but scholarly data sets in the humanities should be.  Input and output for these libraries works with simple, rigorously defined text structures that should easily be able to outlast the lifespan of any running system.  Internally, all identification of technology-independent concepts is by URN.  This abstraction should simplify interaction with other systems today, and express APIs in terms that could be readily expressed in other languages, today or in the future.


[xcoder]: http://sourceforge.net/projects/epidoc/files/Transcoder/


[sparkie]: http://spark.apache.org/

---

[^plut]: Plutarch, *Life of Antony*, 28:  Anthony wasted τὸ πολυτελέστατον, ὡς Ἀντιφῶν εἶπεν, ἀνάλωμα, τὸν χρόνον.

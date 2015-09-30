// Reads a file of UTF8 Greek, and writes it to standard output
// converted to FST tokens, courtesy of Hugh Cayless' transcoder.
//
// Grabs the transcoder jar dynamically, so you must be online to use this.
//
@GrabResolver(name='pap', root='http://dev.papyri.info/maven')
@Grab(group='edu.unc.epidoc', module='transcoder', version='1.2-SNAPSHOT')

import edu.unc.epidoc.transcoder.TransCoder

String usg = "Usage: groovy utf8ToFstToken.groovy <FILENAME>"
if (args.size() != 1) {
  System.err.println usg
  System.exit(-1)
}
File utf8File = new File(args[0])

TransCoder utf2beta = new TransCoder()
utf2beta.setParser("Unicode")
utf2beta.setConverter("BetaCode")

utf8File.eachLine { u ->
  println utf2beta.getString(u).replaceAll(/[=\\/\\\\]/,"").toLowerCase()
}

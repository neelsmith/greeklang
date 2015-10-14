/*
groovy script to run fst-infl
*/


// defaults:

String fstinfl = "/usr/bin/fst-infl"
String transducer = "/usr/local/morphology/greek.a"

def cli = new CliBuilder(usage: 'greek.groovy -[uelp]')
cli.with {
  h longOpt: 'help', 'Show usage information'
  u longOpt: 'urn', 'Include analytical urns only'
  e longOpt: 'explain', 'Include explanatory URNs in output'
  l longOpt: 'legible', 'Include human-readable text in output'

  p longOpt: 'parser', args: 1, argName: 'parser', 'Binary transducer to use in parsing'
  i longOpt: 'fstinfl', args: 1, argName: 'fstinfl', 'Path to fst-infl'

}

def options = cli.parse(args)
def extraArguments = options.arguments()

if (!options) {
  //?
}

// Show usage text when -h or --help option is used.
if (options.h) {
  cli.usage()
  System.exit(0)
}

if (options.p) {
  transducer = options.p
}
if (options.i) {
  fstinfl = options.i
}

String cmd = "${fstinfl} ${transducer}"

if (extraArguments.size() > 0) {
  println "Parse files or directories"
} else {
  println "Run interactively"
  cmd.execute()
}

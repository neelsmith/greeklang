/*
groovy script to run fst-infl

Options to support:

# -u -urns. URN output only
# -e --explain. Include second-tier urns
# -l --legible. Human-readable output

*/

def cli = new CliBuilder(usage: 'greek.groovy -[uelp]')

// Create the list of options.
cli.with {
  h longOpt: 'help', 'Show usage information'
  u longOpt: 'urn', 'Include analytical urns only'
  e longOpt: 'explain', 'Include explanatory URNs in output'
  l longOpt: 'legible', 'Include human-readable text in output'

  p longOpt: 'parser', args: 1, argName: 'parser', 'Binary parser to use'
}

def options = cli.parse(args)
def extraArguments = options.arguments()

if (!options) {
  //?
}

// Show usage text when -h or --help option is used.
if (options.h) {
  cli.usage()
}

if (options.p) {
  println "Use binary transducer " + options.p + " for parser"
}


if (extraArguments.size() > 0) {
  println "Parse files or directories"
} else {
  println "Run interactively"
}

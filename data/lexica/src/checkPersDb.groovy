
import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql




groovy.sql.Sql lexents = Sql.newInstance("jdbc:sqlite:lexent.db", "org.sqlite.JDBC")
def lexData = lexents.dataSet("lexent")

File idFile = new File(args[0])

idFile.eachLine { ln -> 
  String query = "SELECT * FROM lexent WHERE URN = '" + ln + "'"
  System.err.print "Checking entry for ${query}..."
  

  Integer foundCount = 0
  lexData.eachRow(query) { r ->
    foundCount++;
  }

  if (foundCount == 0) {
    println "ERROR: no match for " + ln
  } else if (foundCount > 1) {
    println "ERROR: ambiguous pkey for " + ln
  } else if (foundCount == 1) {
    System.err.println "matched."
  }
}

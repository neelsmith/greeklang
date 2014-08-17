import au.com.bytecode.opencsv.CSVReader
import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

File csvFile = new File(args[0])

System.err.println "Buidling sqlite database from csv file " + csvFile

groovy.sql.Sql lexents = Sql.newInstance("jdbc:sqlite:lexent.db", "org.sqlite.JDBC")
lexents.execute("drop table if exists lexent")
lexents.execute("create table lexent (urn string primary key, lemma string,shortdef string)")
def lexData = lexents.dataSet("lexent")

System.err.println "Created data set. Now parsing CSV..."


CSVReader reader = new CSVReader(new FileReader(csvFile))        

Integer count = 0
Integer omits = 0
reader.readAll().each { cols ->
  if (count == 0) {
    // skip header line
  } else {
    if (cols.size() >= 3) {
      lexData.add(urn: cols[0], lemma: cols[1], shortdef: cols[2])
      System.err.println "Adding entry for ${cols[1]}..."
    } else {
      System.err.println "Skipping input line with ${cols.size()} data columns."
      omits++;
    }
  }
  count++;
}

println "\nOmitted ${omits} input lines out of ${count} total."

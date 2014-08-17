
import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql




groovy.sql.Sql lexents = Sql.newInstance("jdbc:sqlite:lexent.db", "org.sqlite.JDBC")
def lexData = lexents.dataSet("lexent")

File idFile = new File(args[0])

idFile.eachLine { ln -> 
  String query = "DELETE FROM lexent WHERE URN = '" + ln + "'"
  System.err.print "Executing ${query}...\n"
  lexents.execute('delete from lexent where urn = ?' , [ln])  
}


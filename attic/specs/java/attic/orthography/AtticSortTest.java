package attic.orthography;



import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.attic.AtticString;

@RunWith(ConcordionRunner.class)
public class AtticSortTest  {

  public String compareAttic(String raw1, String raw2)
  throws Exception {
    AtticString s1 = new AtticString(raw1);
    AtticString s2 = new AtticString(raw2);
    int cf = s1.compareTo(s2);
    //System.err.println ("Comparing " + s1.toString() + " and " + s2.toString() + " yields: ");
    //  System.err.println(cf);
    if ( cf > 0) {
      return("after");
    } else if (cf < 0 ) {
      return("before") ;
    } else {
      return("equal");
    }
  }
}

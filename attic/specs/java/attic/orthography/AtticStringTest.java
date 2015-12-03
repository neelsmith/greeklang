package attic.orthography;



import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.attic.AtticString;

@RunWith(ConcordionRunner.class)
public class AtticStringTest  {

  public String asUnicode(String str) {
	   AtticString s;
     try {
       s = new AtticString(str);
	      return s.toString(true);
      } catch (Exception e) {
        System.err.println("Exception in test: " + e.toString());
        return null;
	     }
     }

}

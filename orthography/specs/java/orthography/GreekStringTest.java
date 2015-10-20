package orthography;



import edu.holycross.shot.greekutils.GreekString;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class GreekStringTest  {




    public String getAsciiString(String str) {
	GreekString gs;
	try {
	    gs = new GreekString(str);
	    return gs.toString();
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }




}

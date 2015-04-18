package greek.tokens;


import org.concordion.integration.junit3.ConcordionTestCase;

import edu.holycross.shot.greekutils.GreekString;

public class GreekStringTest extends ConcordionTestCase {



    
    public String getBetaString(String str) {
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

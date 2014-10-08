package specs.greek;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.greekutils.GreekString;

/* Run this class as a JUnit test. */

@RunWith(ConcordionRunner.class)
public class GreekStringFixture  {
    
    public String getBetaString(String str) {
        //return new Greeter().greetingFor(firstName);
	GreekString gs;
	try {
	    gs = new GreekString(str);
	    return gs.toString();
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }




    public String getBetaForUnicode(String str) {
	GreekString gs;
	try {
	    gs = new GreekString(str, "Unicode");
	    return gs.toString();
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }
}

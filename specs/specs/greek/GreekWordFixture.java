package specs.greek;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.greekutils.GreekWord;

/* Run this class as a JUnit test. */

@RunWith(ConcordionRunner.class)
public class GreekWordFixture  {
    
    public String getString(String str) {
	GreekWord gw;
	try {
	    gw = new GreekWord(str);
	    return gw.toString();
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }

}

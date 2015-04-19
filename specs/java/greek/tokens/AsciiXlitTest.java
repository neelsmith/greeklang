package greek.tokens;

//import org.concordion.integration.junit4.ConcordionRunner;
//import org.junit.runner.RunWith;
import org.concordion.integration.junit3.ConcordionTestCase;

import edu.holycross.shot.greekutils.GreekString;

/* Run this class as a JUnit test. */
//@RunWith(ConcordionRunner.class)
public class AsciiXlitTest extends ConcordionTestCase {
    
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


    
    public String uForBeta(String str) {
	GreekString gs;
	try {

	    System.err.println ("Get unicode for " + str);
	    gs = new GreekString(str);
	    return gs.toString(true);
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

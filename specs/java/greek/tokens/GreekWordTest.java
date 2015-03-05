package greek.tokens;

//import org.concordion.integration.junit4.ConcordionRunner;
//import org.junit.runner.RunWith;
import org.concordion.integration.junit3.ConcordionTestCase;
import edu.holycross.shot.greekutils.GreekWord;
import edu.holycross.shot.greekutils.GreekString;

import java.util.ArrayList;


/* Run this class as a JUnit test. */

//@RunWith(ConcordionRunner.class)
public class GreekWordTest extends ConcordionTestCase {



    public Iterable<String>  getTokensInString(String raw)
    throws Exception {
	ArrayList<String> tokens = new ArrayList<String> ();
	try {
	    GreekString s = new GreekString(raw, "Unicode");
	    tokens = GreekString.tokenize(s);
	    return tokens;
	} catch (Exception e) {
	    System.err.println ("getTokensInString: failed with exception " + e.toString());
	    throw e;
	}
    }

    
    public String getString(String str)   {
	GreekWord gw;
	try {
	    gw = new GreekWord(str);
	    return gw.toString();
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }





      public String toUnicode(String str)   {
	GreekWord gw;
	try {
	    gw = new GreekWord(str);
	    return gw.toString(true);
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }
}

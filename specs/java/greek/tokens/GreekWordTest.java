package greek.tokens;

//import org.concordion.integration.junit4.ConcordionRunner;
//import org.junit.runner.RunWith;
import org.concordion.integration.junit3.ConcordionTestCase;
import edu.holycross.shot.greekutils.GreekWord;

/* Run this class as a JUnit test. */

//@RunWith(ConcordionRunner.class)
public class GreekWordTest extends ConcordionTestCase {
    
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

}

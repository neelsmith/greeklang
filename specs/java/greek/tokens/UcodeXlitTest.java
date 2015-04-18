package greek.tokens;

import edu.holycross.shot.greekutils.GreekString;

import org.concordion.integration.junit3.ConcordionTestCase;

public class UcodeXlitTest extends ConcordionTestCase {

        public String asUnicode(String str) {
	GreekString gs;
	try {
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


        public String uForU(String str) {
	GreekString gs;
	try {
	    gs = new GreekString(str, "Unicode");
	    return gs.toString(true);
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }

}

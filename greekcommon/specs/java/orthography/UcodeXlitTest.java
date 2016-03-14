package orthography;

import edu.holycross.shot.orthography.GreekString;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class UcodeXlitTest {

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
	    gs = new GreekString(str, true);
	    return gs.toString();
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }


        public String uForU(String str) {
	GreekString gs;
	try {
	    gs = new GreekString(str,true);
	    return gs.toString(true);
	} catch (Exception e) {
	    System.err.println("Exception in test: " + e.toString());
	    return null;
	}

    }

}

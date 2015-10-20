package orthography;

import edu.holycross.shot.greekutils.GreekString;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class AsciiXlitTest {

    public String getAsciiString(String str) {
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



    public String uForAscii(String str) {
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


    public String getAsciiForUnicode(String str) {
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

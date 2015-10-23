package orthography;


import edu.holycross.shot.orthography.GreekWord;
import edu.holycross.shot.orthography.GreekString;

import java.util.ArrayList;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class MsWordTest  {



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

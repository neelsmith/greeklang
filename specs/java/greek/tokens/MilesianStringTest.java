package greek.tokens;


import org.concordion.integration.junit3.ConcordionTestCase;

import edu.holycross.shot.greekutils.MilesianString;

public class MilesianStringTest extends ConcordionTestCase {

    public boolean isDigit(String str) {
	return MilesianString.isDigit(str);
    }

    public String toStr(String s)
    throws Exception {
	    MilesianString ms = new MilesianString(s);
	    return ms.toString();
    }


    public String toBetaCode(String s)
    throws Exception {
	    MilesianString ms = new MilesianString(s);
	    return ms.toString(true);
    }
}

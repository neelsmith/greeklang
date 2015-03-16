package greek.tokens.milesian;


import org.concordion.integration.junit3.ConcordionTestCase;

import edu.holycross.shot.greekutils.MilesianString;

public class MilesianSyntaxTest extends ConcordionTestCase {

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

    public boolean isValid(String s) {
	try {
	    MilesianString ms = new MilesianString(s);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }


    public boolean hasIntegerPart(String s)
    throws Exception {
	MilesianString ms = new MilesianString(s);
	return ms.hasIntegerPart();
    }


    
    public String getIntegerPart(String s)
    throws Exception {
	MilesianString ms = new MilesianString(s);
	return ms.getIntegerPart();
    }


    public String getFractionPart(String s)
	throws Exception {
	MilesianString ms = new MilesianString(s);
	return ms.getFractionPart();
    }
	
}

package greek.tokens.milesian;


import org.concordion.integration.junit3.ConcordionTestCase;

import edu.holycross.shot.greekutils.MilesianInteger;
import edu.holycross.shot.greekutils.MilesianString;
import java.math.BigDecimal;

public class MilesianCompoundTest extends ConcordionTestCase {


    public String xscribe (String s)
    throws Exception {
	try {
	    MilesianString ms = new MilesianString(s);
	    return ms.xscribe();
	} catch (Exception e) {
	    throw e;
	}
    }


    public BigDecimal toDecimal(String s)
	throws Exception {
	try {
	    MilesianString ms = new MilesianString(s);
	    return ms.toDecimal();
	} catch (Exception e) {
	    throw e;
	}
    }


    public BigDecimal toDecimal(String s, Integer digits)
	throws Exception {
	try {
	    MilesianString ms = new MilesianString(s);
	    return ms.toDecimal(digits);
	} catch (Exception e) {
	    throw e;
	}
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

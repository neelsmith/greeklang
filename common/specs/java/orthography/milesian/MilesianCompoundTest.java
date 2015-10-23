package orthography.milesian;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.orthography.MilesianInteger;
import edu.holycross.shot.orthography.MilesianString;
import java.math.BigDecimal;

@RunWith(ConcordionRunner.class)
public class MilesianCompoundTest  {


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

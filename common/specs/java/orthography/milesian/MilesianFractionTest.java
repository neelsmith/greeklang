package orthography.milesian;


import org.concordion.integration.junit3.ConcordionTestCase;

import java.math.BigDecimal;

import edu.holycross.shot.orthography.MilesianFraction;


public class MilesianFractionTest extends ConcordionTestCase {

    public String xcribe (String s)
    throws Exception {
	MilesianFraction mf = new MilesianFraction(s);
	return mf.transcription;
    }


    public BigDecimal toDecimal (String s, Integer places)
    throws Exception {
	MilesianFraction mf = new MilesianFraction(s);
	return mf.getFractionValue(places);
    }


    /** tests default precision */
    public BigDecimal toDecimal (String s)
    throws Exception {
	MilesianFraction mf = new MilesianFraction(s);
	return mf.getFractionValue();
    }

}

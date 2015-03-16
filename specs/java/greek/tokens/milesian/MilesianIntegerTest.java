package greek.tokens.milesian;


import org.concordion.integration.junit3.ConcordionTestCase;

import edu.holycross.shot.greekutils.MilesianInteger;
import edu.holycross.shot.greekutils.MilesianString;
import java.lang.StringBuffer;

public class MilesianIntegerTest extends ConcordionTestCase {

    public Integer getDigitValue(String digit)
    throws Exception {
	StringBuffer buff = new StringBuffer(digit);
	int cp = buff.codePointAt(0);
	return MilesianInteger.getDigitValue(cp);
    }

    public Integer milesianToInteger(String str)
    throws Exception {
	MilesianString ms = new MilesianString(str);
	MilesianInteger mi = new MilesianInteger(ms);
	return MilesianInteger.toInteger(mi.codePoints);
    }
}

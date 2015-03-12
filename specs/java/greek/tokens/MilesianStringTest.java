package greek.tokens;


import org.concordion.integration.junit3.ConcordionTestCase;

import edu.holycross.shot.greekutils.MilesianString;

public class MilesianStringTest extends ConcordionTestCase {

    public boolean isDigit(String str) {
	return MilesianString.isDigit(str);
    }
}

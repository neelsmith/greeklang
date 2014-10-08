package specs.greek.tokens;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.greekutils.BetaComparator;

/* Run this class as a JUnit test. */

@RunWith(ConcordionRunner.class)
public class GreekSortFixture  {
    
    public String greekSort(String s1, String s2) {
	switch ( BetaComparator.compare(s1, s2)) {
	case 0:
	    return "equal";

	case 1:
		return s2;

	case -1:
		return s1;

	default:
	    System.err.println("Something went wrong sorting " + s1 + " and " + s2 + ".");
	    break;
	}
	return null;
    }

}

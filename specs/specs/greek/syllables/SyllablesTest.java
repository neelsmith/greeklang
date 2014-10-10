package specs.greek.syllables;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.greekutils.GreekWord;

/* Run this class as a JUnit test. */

@RunWith(ConcordionRunner.class)
public class SyllablesTest  {
    
    public Iterable<String>  getSyllables(String str) {
	return GreekWord.getSyllables(str);
    }

}

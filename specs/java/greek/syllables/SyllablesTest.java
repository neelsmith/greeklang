package greek.syllables;


import org.concordion.integration.junit3.ConcordionTestCase;
import edu.holycross.shot.greekutils.GreekWord;

public class SyllablesTest extends ConcordionTestCase {

    public Iterable<String>  getSyllables(String str) {
	return GreekWord.getSyllables(str);
    }

}

package attic.orthography;



import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import edu.holycross.shot.attic.AtticString;
import java.util.ArrayList;

@RunWith(ConcordionRunner.class)
public class AtticWordTest  {


  public Iterable<String> tokenize(String attic)
  throws Exception {
    ArrayList<String> tokenList = new ArrayList<String>();
    ArrayList tokenization = AtticString.tokenize(new AtticString(attic));


		for (int i = 0; i < tokenization.size(); i++) {
      AtticString oneToken = (AtticString) tokenization.get(i);
			tokenList.add(oneToken.toString());


    }
    return tokenList;
  }
}

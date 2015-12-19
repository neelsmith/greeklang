package attic.orthography;



import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.attic.AtticString;
import edu.holycross.shot.attic.AtticPhonology;

@RunWith(ConcordionRunner.class)
public class AsciiSummaryTest  {
  public int countValidChars() {
    return (countXcriptionChars() + countEditorialChars() + countWhitespaceChars());
  }
  public int countWhitespaceChars() {
    return (AtticString.whiteSpace.size());
  }

  public int countEditorialChars() {
    int elision = 1;
    return (AtticPhonology.quantity.size() + AtticPhonology.accent.size() + elision);
}
  public int countXcriptionChars() {

    return (AtticPhonology.consonant.size() + AtticPhonology.vowel.size() + AtticString.punctuation.size());
  }

  public boolean isValidString(String s)
  throws Exception {
    AtticString attic = new AtticString(s);
    return attic.isValid();
  }


    public boolean isValidCP(int decimalCodePt)
    throws Exception {
      String ascii = new String(Character.toChars(decimalCodePt));
      AtticString attic = new AtticString(ascii);
      return attic.isValid();
    }


}

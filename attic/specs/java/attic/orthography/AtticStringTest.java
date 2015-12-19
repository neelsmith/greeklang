package attic.orthography;



import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.attic.AtticString;
import edu.holycross.shot.attic.AtticPhonology;

@RunWith(ConcordionRunner.class)
public class AtticStringTest  {



  public boolean isValidUString(String s)
  throws Exception {
    AtticString attic = new AtticString(s, true);
    return attic.isValid();
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

  public String getRoughBreathing() {
    return("H");
  }


  public String uForAscii(String ascii)
    throws Exception {
      AtticString attic = new AtticString(ascii);
      return attic.toString(true);
  }

  public String asciiForU(String u)
  throws Exception {
    AtticString attic = new AtticString(u, true);
    return attic.toString();
  }
  public int countAlphas() {
    return (AtticPhonology.consonant.size() + AtticPhonology.vowel.size());
  }
  public String asUnicode(String str) {
	   AtticString s;
     try {
       s = new AtticString(str);
	      return s.toString(true);
      } catch (Exception e) {
        System.err.println("Exception in test: " + e.toString());
        return null;
	     }
     }

}

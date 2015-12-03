package attic.phonology;


import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import edu.holycross.shot.attic.AtticPhonology;

@RunWith(ConcordionRunner.class)
public class PhonologyTest {

  public int countVowels() {
    return AtticPhonology.getVowels().size();
  }

  public int countConsonants() {
    return AtticPhonology.getConsonants().size();
  }


  public int countAlphabetic() {
    return (countVowels() + countConsonants() );
  }

  public String alphaType(String ch) {
    if (AtticPhonology.isConsonant(ch)) {
      return "consonant";
    } else if (AtticPhonology.isVowel(ch)) {
      return "vowel";
    } else {
      return "no alphabetic";
    }
  }
}

package attic.orthography;



import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import edu.holycross.shot.attic.AtticString;
import edu.holycross.shot.attic.AtticSyllable;
import edu.holycross.shot.attic.AtticWord;
import edu.holycross.shot.phonology.AccentPattern;

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


  public Iterable<String> syllabify(String attic)
  throws Exception {
    ArrayList<String> syllableList = new ArrayList<String>();


    ArrayList syllables = AtticSyllable.getSyllables(new AtticWord(attic));

    for (int i = 0; i < syllables.size(); i++) {
      Object x = syllables.get(i);
      syllableList.add(x.toString());
    }
    return syllableList;
  }

  public String addAsciiAcc(String lex, String accentType)
  throws Exception {
    AtticWord atticWord = new AtticWord(lex);
    AtticWord accentedWord = new AtticWord("");
    if (accentType.equals("recessive")) {
      accentedWord = atticWord.accent(edu.holycross.shot.phonology.AccentPattern.RECESSIVE);
    } else if (accentType.equals("penult")) {
      accentedWord = atticWord.accent(edu.holycross.shot.phonology.AccentPattern.PENULT);
    } else if (accentType.equals("ultima")) {
      accentedWord = atticWord.accent(edu.holycross.shot.phonology.AccentPattern.ULTIMA);
    }
    return accentedWord.toString();
  }


  public String addUcodeAcc(String lex, String accentType)
  throws Exception {
    AtticWord atticWord = new AtticWord(lex);
    AtticWord accentedWord = new AtticWord("");
    if (accentType.equals("recessive")) {
      accentedWord = atticWord.accent(edu.holycross.shot.phonology.AccentPattern.RECESSIVE);
    } else if (accentType.equals("penult")) {
      accentedWord = atticWord.accent(edu.holycross.shot.phonology.AccentPattern.PENULT);
    } else if (accentType.equals("ultima")) {
      accentedWord = atticWord.accent(edu.holycross.shot.phonology.AccentPattern.ULTIMA);
    }
    return accentedWord.toString(true);
  }

}

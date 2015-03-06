package greek.morphology;



import org.concordion.integration.junit3.ConcordionTestCase;
import edu.holycross.shot.jmorph.MorphForm;

public class AnalysisTest extends ConcordionTestCase {
    

    public String getPoS(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getPartOfSpeech().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }

    public String getGender(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getGender().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }


    public String getCase(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getCase().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }


    public String getNumber(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getNumber().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }



    public String getPerson(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getPerson().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }



    public String getTense(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getTense().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }



    public String getMood(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getMood().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }

    public String getVoice(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getVoice().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }



    public String getDegree(String str) {
	try  {
	    MorphForm mf = new MorphForm(str);
	    return mf.getDegree().toString().toLowerCase();
	} catch (Exception e) {
	    System.err.println ("Could not make an analysis from " + str );
	}
	return null;
    }



}

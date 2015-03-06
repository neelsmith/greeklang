
#Morphological analyses


Every morphological analysis identifies a part of speech. Depending on the part of speech, the analysis identifies further properties. The complete set of possible properties is:  person, number, tense, mood, voice, gender, case, degree.


For conjugated verbs, an analysis identifies:  person, number, tense, mood and voice.


For all substantives, an analysis identifies: gender, case and number.  For adjectives, it
further identifies degree.

For participial forms of verbs, the "mood" is (untraditionally) considered "participle", and the analysis further identifies
tense, voice, gender, case and number.

Analyses can be serialized to and created from delimited text strings giving all eight possible properties of an analysis plus a
part of speech.

@openex@


### Example: a conjugated verb ###


  

  <code
  concordion:set="#verb">first:singular:present:indicative:active::::verb</code>
  is a complete analysis of a conjugated verb form, with the following   properties set:


  <table>
    <tr>
      <th>Property</th><th>Value</th>
    </tr>
    <tr>
      <td>Part of speech</td>
      <td concordion:assertEquals="getPoS(#verb)">verb</td>
    </tr>
 <tr>
      <td>Person</td>
      <td concordion:assertEquals="getPerson(#verb)">first</td>
    </tr>
<tr>
      <td>Number</td>
      <td concordion:assertEquals="getNumber(#verb)">singular</td>
    </tr>
<tr>
      <td>Tense</td>
      <td concordion:assertEquals="getTense(#verb)">present</td>
    </tr>

  </table>


  @closeex@


@openex@

### Example: a noun ###


  
<code
  concordion:set="#noun">:singular::::masculine:genitive::noun</code>
  is a complete analysis of a noun form, with the following   properties set:


  <table>
    <tr>
      <th>Property</th><th>Value</th>
    </tr>
    <tr>
      <td>Part of speech</td>
      <td concordion:assertEquals="getPoS(#noun)">noun</td>
    </tr>
<tr>
      <td>Gender</td>
      <td concordion:assertEquals="getGender(#noun)">masculine</td>
    </tr>

<tr>
      <td>Case</td>
      <td concordion:assertEquals="getCase(#noun)">genitive</td>
    </tr>

<tr>
      <td>Number</td>
      <td concordion:assertEquals="getNumber(#noun)">singular</td>
    </tr>

  </table>

@closeex@



@openex@


###Example: a participle
  
 
  <code
  concordion:set="#ptcpl">:singular:present:participle:active:masculine:nominative::verb</code>
  is a complete analysis of a participle, with the following   properties set:




  <table>
    <tr>
      <th>Property</th><th>Value</th>
    </tr>
    <tr>
      <td>Part of speech</td>
      <td concordion:assertEquals="getPoS(#ptcpl)">verb</td>
    </tr>

<tr>
      <td>Mood</td>
      <td concordion:assertEquals="getMood(#ptcpl)">participle</td>
    </tr>

<tr>
      <td>Number</td>
      <td concordion:assertEquals="getNumber(#ptcpl)">singular</td>
    </tr>

<tr>
      <td>Tense</td>
      <td concordion:assertEquals="getTense(#ptcpl)">present</td>
    </tr>

<tr>
      <td>Voice</td>
      <td concordion:assertEquals="getVoice(#ptcpl)">active</td>
    </tr>

<tr>
      <td>Gender</td>
      <td concordion:assertEquals="getGender(#ptcpl)">masculine</td>
    </tr>

<tr>
      <td>Case</td>
      <td concordion:assertEquals="getCase(#ptcpl)">nominative</td>
    </tr>

    
  </table>

@closeex@
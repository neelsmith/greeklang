

##Classifying non-white-space characters and strings


Individual characters in a lexical token can be classified as:


- alphabetic.  These can be further classified  as vowels or consonants.
- accents
- breathings
- punctuation


@openex@

### Example: mh=nin

  <table>
    <tr>
      <th>Token</th>
      <th>Class</th>
    </tr>

   <tr>
      <td concordion:set="#src">m</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span concordion:assertTrue="isConsonant(#src)">consonant</span></td>
    </tr>

    
   <tr>
      <td concordion:set="#src">h</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span
      concordion:assertTrue="isVowel(#src)">vowel</span></td>
    </tr>



<tr>
      <td concordion:set="#src">=</td><td><span
	concordion:assertTrue="isAccent(#src)">accent</span></td>
      </tr>


 <tr>
      <td concordion:set="#src">n</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span concordion:assertTrue="isConsonant(#src)">consonant</span></td>
    </tr>

   <tr>
     <td concordion:set="#src">i</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span
      concordion:assertTrue="isVowel(#src)">vowel</span></td>
    </tr>
    
   <tr>
      <td concordion:set="#src">n</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span concordion:assertTrue="isConsonant(#src)">consonant</span></td>
    </tr>

    
  </table>

@closeex@


@openex@
  
### Example: a)/eide
   
<table>
    <tr>
      <th>Token</th>
      <th>Class</th>
    </tr>

  <tr>
      <td concordion:set="#src">a</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span
      concordion:assertTrue="isVowel(#src)">vowel</span></td>
    </tr>

 <tr>
      <td concordion:set="#src">)</td><td><span
      concordion:assertTrue="isBreathing(#src)">breathing</span>
      </td>
    </tr>

<tr>
      <td concordion:set="#src">/</td><td><span
      concordion:assertTrue="isAccent(#src)">accent</span>
      </td>
    </tr>




<tr>
      <td concordion:set="#src">e</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span
      concordion:assertTrue="isVowel(#src)">vowel</span></td>
    </tr>

<tr>
      <td concordion:set="#src">i</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span
      concordion:assertTrue="isVowel(#src)">vowel</span></td>
    </tr>

 <tr>
      <td concordion:set="#src">d</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span concordion:assertTrue="isConsonant(#src)">consonant</span></td>
    </tr>

<tr>
      <td concordion:set="#src">e</td><td><span
      concordion:assertTrue="isAlphabetic(#src)">alphabetic</span>
	and <span
      concordion:assertTrue="isVowel(#src)">vowel</span></td>
    </tr>
    
</table>

@closeex@

@openex@

###Others

  <table>
    <tr>
      <th>Token</th>
      <th>Class</th>
    </tr>

 <tr>
      <td concordion:set="#src">,</td><td
    concordion:assertTrue="isPunctuation(#src)">punctuation</td>
    </tr>

<tr>
      <td concordion:set="#src">j</td><td
    concordion:assertFalse="isValid(#src)">not a valid character</td>
    </tr>
    
  </table>

@closeex@

Pairs of vowels in a lexical token can be classified as   diphthongs.



@openex@

### Example: diphthongs ###


<table>
<tr>
      <th>Token</th>
      <th>Class</th>
    </tr>

<tr>
      <td concordion:set="#src">ou</td><td
    concordion:assertTrue="isDiphthong(#src)">diphthong</td>
    </tr>
  </table>

@closeex@


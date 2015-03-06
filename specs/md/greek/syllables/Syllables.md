# Syllabification of Greek tokens

Every syllable includes a single vowel or diphthong.


@openex@

### Example

Find syllables in the token <strong concordion:set="#wd">mh=nin</strong>:


<table concordion:verifyRows="#syll : getSyllables(#wd)">
 <tr>
    <th concordion:assertEquals="#syll">Syllable</th>
  </tr>

  <tr><td>mh=</td></tr>
  <tr><td>nin</td></tr>

</table>

@closeex@
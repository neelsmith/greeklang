# Summary of valid characters in ASCII mapping

The ASCII mapping of Attic Geek includes <strong concordion:assertEquals="countValidChars()">34</strong> valid characters, composed of <strong concordion:assertEquals="countXcriptionChars()">23</strong> alphabetic and punctuation characters used in the Attic writing system, <strong concordion:assertEquals="countWhitespaceChars()">5</strong>
tokenizing white space characters, and <strong concordion:assertEquals="countEditorialChars()">6</strong> editorial characters.

Alphabetic and punctuation characters used in the Attic writing system:

<table concordion:execute="#result = isValidString(#src)">

<tr>
  <th  >Character </th>
  <th concordion:set="#src" >ASCII representation</th>
  <th concordion:assertEquals="#result">Valid mapping?</th>
</tr>
<tr><td>alpha (long or short vowel)</td><td>A</td><td>true</td></tr>
<tr><td>beta</td><td>B</td><td>true</td></tr>
<tr><td>gamma</td><td>G</td><td>true</td></tr>
<tr><td>delta</td><td>D</td><td>true</td></tr>
<tr><td>short epsilon, long eta, or diphthong ei</td><td>E</td><td>true</td></tr>
<tr><td>zeta</td><td>Z</td><td>true</td></tr>
<tr><td>theta</td><td>Q</td><td>true</td></tr>
<tr><td>iota (long or short vowel)</td><td>I</td><td>true</td></tr>
<tr><td>kappa</td><td>K</td><td>true</td></tr>
<tr><td>lamda</td><td>L</td><td>true</td></tr>
<tr><td>mu</td><td>M</td><td>true</td></tr>
<tr><td>nu</td><td>N</td><td>true</td></tr>
<tr><td>short omicron, long omega, or diphthong ou</td><td>O</td><td>true</td></tr>
<tr><td>pi</td><td>P</td><td>true</td></tr>
<tr><td>rho</td><td>R</td><td>true</td></tr>
<tr><td>sigma</td><td>S</td><td>true</td></tr>
<tr><td>tau</td><td>T</td><td>true</td></tr>
<tr><td>upsilon (long or short vowel)</td><td>U</td><td>true</td></tr>
<tr><td>phi</td><td>F</td><td>true</td></tr>
<tr><td>chi</td><td>X</td><td>true</td></tr>
<tr><td>aspirate (rough breathing)</td><td>H</td><td>true</td></tr>
<tr><td>major break</td><td>.</td><td>true</td></tr>
<tr><td>secondary break</td><td>:</td><td>true</td></tr>
</table>


Tokenizing white space characters:

<table concordion:execute="#result = isValidCP(#src)">

<tr>
  <th>Tokenizing character</th>
   <th concordion:set="#src">Code point (decimal)</th>
  <th concordion:assertEquals="#result">Valid character?</th>
</tr>

<tr><td>Space</td><td>32</td><td>true</td></tr>
<tr><td>Tab</td><td>9</td><td>true</td></tr>
<tr><td>Line feed</td><td>10</td><td>true</td></tr>
<tr><td>Form feed</td><td>12</td><td>true</td></tr>
<tr><td>Carriage return</td><td>13</td><td>true</td></tr>
</table>


Editorial characters:

<table concordion:execute="#result = isValidCP(#src)">
<tr>
  <th>Editorial disambiguation</th>
   <th concordion:set="#src">Code point (decimal)</th>
  <th concordion:assertEquals="#result">Valid character?</th>
</tr>
<tr><td>Long vowel marker</td><td>95</td><td>true</td></tr>
<tr><td>Short vowel marker</td><td>94</td><td>true</td></tr>

<tr><td>Circumflex</td><td>61</td><td>true</td></tr>
<tr><td>Acute</td><td>47</td><td>true</td></tr>
<tr><td>Grave</td><td>92</td><td>true</td></tr>
<tr><td>Elision</td><td>39</td><td>true</td></tr>
</table>

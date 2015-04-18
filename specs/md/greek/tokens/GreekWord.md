# Lexical tokens (Greek words)

Lexical tokens are composed only of valid Greek characters [as specified for Greek strings](GreekString.html), except white-space characters.   Lexical tokens may be created directly from strings, and converted back to strings, following the same rules as for Greek strings.



@openex@

### Examples

Create a lexical token from a string, and convert it back to a string:

  
 <table concordion:execute="#result = getString(#wd)">
	<tr>
	  <th concordion:set="#wd">Source string</th>
	  <th concordion:assertEquals="#result">Token as a String</th>
	</tr>

<tr><td>MH=NIN</td><td>mh=nin</td></tr>
<tr><td>mh=nin</td><td>mh=nin</td></tr>
<tr><td>Mh=nin</td><td>mh=nin</td></tr>
<tr><td>*mh=nin</td><td>*mh=nin</td></tr>
	
   </table>
@closeex@



## Tokenization ##


A Greek string may comprise more than one lexical token.  White space characters that are permitted in GreekStrings but not in Greek words delimit tokens within a String. The GreekString class can create a list of Greek Words from a Greek String.

@openex@

Tokenizing the following Unicode string 
<pre concordion:set="#raw">Ζεὺς δ' Ἔριδα προΐαλλε θοὰς ἐπὶ νῆας Ἀχαιῶν
</pre>

yields  this ordered list of GreekWords:

 <table concordion:verifyRows="#token : getTokensInString(#raw)">
<tr><th concordion:assertEquals="#token">Verb (with abbreviated prefix)</th></tr>

<tr><td>*zeu\s</td></tr>
<tr><td>d'</td></tr>
<tr><td>*)/erida</td></tr>
<tr><td>proi+/alle</td></tr>
<tr><td>qoa\s</td></tr>
<tr><td>e)pi\</td></tr>
<tr><td>nh=as</td></tr>
<tr><td>*)axaiw=n</td></tr>
</table>




@closeex@



Like GreekStrings, GreekWords can be represented as Unicode strings in NFC form.



 <table concordion:execute="#to = toUnicode(#from)">

<tr>
	  <th concordion:set="#from">Source string</th>
	  <th concordion:assertEquals="#to">As Unicode</th>
	</tr>
<tr><td>*zeu\s</td><td>Ζεὺς</td></tr>
<tr><td>d'</td><td>δʼ</td></tr>
<tr><td>*)/erida</td><td>Ἔριδα</td></tr>
<tr><td>proi+/alle</td><td>προΐαλλε</td></tr>
<tr><td>qoa\s</td><td>θοὰς</td></tr>
<tr><td>e)pi\</td><td>ἐπὶ</td></tr>
<tr><td>nh=as</td><td>νῆας</td></tr>
<tr><td>*)axaiw=n</td><td>Ἀχαιῶν</td></tr>
</table>

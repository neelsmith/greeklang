# GreekStrings

GreekStrings are composed exclusively of characters in the small set relevant for ancient Greek: Greek alphabetic characters, accents, breathings, punctuation marks or white space.

GreekStrings are created from Strings by mapping Unicode code points on to the ancient Greek characters according to one of two mappings:

- an alphabetic subset of the TLG project's <a concordion:run="concordion" href="BetaCodeXlit.html">Beta Code</a>
- a subset of the <a concordion:run="concordion" href="UcodeXlit.html">ancient Greek range</a> of Unicode



When GreekStrings are converted back to Strings, they use the the beta-code convention, with all alphabetic characters represented by lower-case Roman characters. An asterisk identifies an upper-case character in the GreekString.

## Unicode Greek mapping ##


A GreekString may be created from either precombined or combining Unicode codepoints.  Equivalent values in Unicode are 


@openex@

###Examples


<table concordion:execute="#result = getBetaForUnicode(#src)">

<tr>
	  <th>Combining/precombined</th>
	  <th concordion:set="#src">Source String</th>
	  <th concordion:assertEquals="#result">GreekString</th>
	</tr>

<tr>
	  <td>combining</td>
	  <td>μῆνιν</td>
	  <td>mh=nin</td>
	</tr>
<tr>
	  <td>combining</td>
	  <td>Μῆνιν</td>
	  <td>*mh=nin</td>
	</tr>

<tr>
	  <td>precombined</td>
	  <td>μῆνιν</td>
	  <td>mh=nin</td>
	</tr>
	  
<tr>
	  <td>precombined</td>
	  <td>Μῆνιν</td>
	  <td>*mh=nin</td>
	</tr>
	
</table>



@closeex@


Whether constructed from beta-code or unicode source string, Greek Strings can converted to Unicode NFC.


@openex@


### Example ###


The ASCII string <strong concordion:set="#beta1">*mh=nin</strong> converts to the NFC Unicode string <strong concordion:assertEquals="asUnicode(#beta1)">Μῆνιν</strong>.

@closeex@


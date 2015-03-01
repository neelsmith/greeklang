# GreekStrings

GreekStrings are objects composed exclusively of characters in the small set relevant for ancient Greek: Greek alphabetic characters, accents, breathings, punctuation marks or white space.

GreekStrings are created from Strings by mapping Unicode code points on to the ancient Greek characters according to one of two mappings:

- an alphabetic subset of the TLG project's Beta Code
- a subset of the Unicode ancient Greek range
- 
When GreekStrings are converted back to Strings, they use the the beta-code convention, with all alphabetic characters represented by lower-case Roman characters. An asterisk identifies an upper-case character in the GreekString.

## Beta-code mapping

A GreekString may be created from a case-insensitive String.

@openex@


### Examples ###


<table concordion:execute="#result = getBetaString(#src)">
	<tr>
	  <th concordion:set="#src">Source String</th>
	  <th concordion:assertEquals="#result">GreekString</th>
	</tr>

	<tr><td>MH=NIN</td><td>mh=nin</td></tr>
	<tr><td>mh=nin</td><td>mh=nin</td></tr>
	<tr><td>Mh=nin</td><td>mh=nin</td></tr>
	<tr><td>*mh=nin</td><td>*mh=nin</td></tr>
	
      </table>
      


@closeex@


## Unicode Greek mapping ##


A GreekString may be created from either precombined or combining Unicode codepoints.


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
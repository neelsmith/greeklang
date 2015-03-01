# Lexical tokens (Greek words)

Lexical tokens are composed only of valid Greek characters, and may include any valid Greek characters except white-space characters. See the specification of a Greek string for details.

Lexical tokens may be created directly from strings, and converted back to strings, following the same rules as Greek strings.

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

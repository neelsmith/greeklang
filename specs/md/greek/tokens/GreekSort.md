
##Sorting tokens


Tokens are sorted accorded to the order of the Greek alphabet.


@openex@
  
###Examples
  
  <table>
    <tr>
      <th>List of words</th><th>First alphabetically</th>  
    </tr>
    
<tr>
      <td>
	<strong concordion:set="#s1">mh=nin</strong>, 
	<strong concordion:set="#s2">a)/eide</strong>
      </td>
      <td>
	<span concordion:assertEquals="greekSort(#s1,
	#s2)">a)/eide</span>
      </td>
    </tr>


  <tr>
     <td>
	<strong concordion:set="#s1">a)/eide</strong>,
	<strong concordion:set="#s2">mh=nin</strong> 
      </td>
      <td>
	<span concordion:assertEquals="greekSort(#s1,
	#s2)">a)/eide</span>
      </td>
    </tr>


   <tr>
     <td>
	<strong concordion:set="#s1">mh=nin</strong>,
	<strong concordion:set="#s2">mh=nin</strong> 
      </td>
      <td>
	<span concordion:assertEquals="greekSort(#s1,
	#s2)">equal</span>
      </td>
    </tr>
    
  </table>

@closeex@
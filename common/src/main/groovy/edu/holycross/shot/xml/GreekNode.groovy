package edu.holycross.shot.xml
/*
def rootElementName = docRoot.name()

println "Document root's name is an object of " + rootElementName.getClass()
println "Document root is named " + rootElementName + " with:"
println "\tlocal name is " + rootElementName.getLocalPart()
println "\tnamespace is " + rootElementName.getNamespaceURI()
*/


import edu.holycross.shot.orthography.GreekString

import edu.holycross.shot.xmlutils.XmlNode

import groovy.xml.Namespace


/** A class for working with Greek text.  A GreekNode represents a well-formed XML node with text nodes composed of string data valid for constructing a GreekString.
 */
class GreekNode extends XmlNode {

  /** Temporary variable to delete before release version. */
  boolean debug = 0



  /* Values defining a magic element wrapping word tokens potentially including
  further markup that extraction needs to burrow through
  */

  /** If non-null, magic element must be in this namespace */
//  String magicNs = ""
  /** If non-null, local name of magic word wrapping element. */
  // String magicNode = ""
  /** If non-null, name of an attribute that must be present on magicNode. */
//  String magicAttrName = ""
  /** If non-null, required value for magic attribute named by magicAttrName. */
  //String magicAttrValue = ""


  /** The root of the XML content as a parsed groovy.util.Node */
  //def parsedNode = null

  boolean xmlGreekInUnicode = ""


  /**
   * Constructs a GreekNode object from a groovy Node object.
   */
  GreekNode (groovy.util.Node n) {
    super (n)
    if (debug) {
      System.err.println "\nConstructing GreekNode from groovy node " + n + "\n"
    }


  }

  /**
   * Constructs a GreekNode object from the XML representation of
   * contents, using default values for character encoding
   * and node namespace.
   * @param content A string of well-formed XML.
   * @param True if text nodes of XML document represent GreekStrings in Unicode mapping,
   * false if text nodes represent Greek in ASCII mapping.
   * @throws Exception if content could not be parsed.
   */
  GreekNode (String content, boolean xmlUnicode) {
    super(content)
    xmlGreekInUnicode = xmlUnicode
  }




  /** Recursively converts a parsed node with Greek in ASCII encoding
  * into Unicode mapping of Greek.
  * @param n The parsed node to convert.
  * @param accumulatedText Previously accumulated text.
  * @returns A String of well-formed XML with text nodes
  * representing Greek in Unicode mapping.
  */
  String getUnicodeXml(Object n, String accumulatedText) {
    if (n.getClass().getName() == "java.lang.String") {
      GreekString gs = new GreekString(n)
      accumulatedText = accumulatedText +  gs.toString(true)
    } else {
      accumulatedText += "<${n.name()}" + collectAttrs(n) + ">"
      n.children().each { child ->
        accumulatedText = getUnicodeXml(child, accumulatedText)
      }
      accumulatedText+= "</${n.name()}>"
	  }
    return accumulatedText
  }



  /** Serializes the context of parsedNode as well-formed XML with Greek text
   * in encoding toEncoding.
   * @return A String of well-formed XML with Greek in encoding toEncoding.
   * @throws Exception if value of enc is not in encodingsList.
   */
  String getUnicodeXml() {
	   getUnicodeXml(parsedNode, "")
  }




}

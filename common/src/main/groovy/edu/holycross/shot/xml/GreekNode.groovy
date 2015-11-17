package edu.holycross.shot.xml

import edu.holycross.shot.orthography.GreekString

import edu.holycross.shot.xmlutils.XmlNode

import groovy.xml.Namespace


/** A class for working with Greek text.  A GreekNode represents a well-formed XML node with text nodes composed of string data valid for constructing a GreekString.
 */
class GreekNode extends XmlNode {

  /** True if text content of XML document is in Unicode. */
  boolean xmlGreekInUnicode = false

  /**
   * Constructs a GreekNode object from a groovy Node object.
   * @param n Parsed Node of XML text with GreekString values in
   * text nodes.
   */
  GreekNode (groovy.util.Node n)
  throws Exception {
    super (n)
    if (! verifyGreek()) {
      throw new Exception("GreekNode:  invalid content in parsed Node.")
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
  GreekNode (String content, boolean xmlUnicode)
  throws Exception {
    super(content)
    xmlGreekInUnicode = xmlUnicode
    if (! verifyGreek()) {
      throw new Exception("GreekNode:  invalid content in parsed Node.")
    }
  }


  /**
   * Constructs a GreekNode object from the XML representation of
   * contents in ASCII encoding of Greek.
   * @param content A string of well-formed XML.
   * @throws Exception if content could not be parsed.
   */
  GreekNode (String content)
  throws Exception {
    super(content)
    xmlGreekInUnicode = false
    if (! verifyGreek()) {
      throw new Exception("GreekNode:  invalid content in parsed Node.")
    }
  }

  /** Determines if text nodes are valid content for GreekStrings.
  * @returns True if all text nodes are valid.
  */
  boolean verifyGreek() {
    return verifyGreek(this.parsedNode)
  }


  /** Determines if text nodes contained by a given node are valid content for GreekStrings.
  * @param n The node to check.
  * @returns True if all text nodes are valid.
  */
  boolean verifyGreek(Object n) {
    boolean valid
    if (n instanceof java.lang.String) {
      try   {
        GreekString gs = new GreekString(n.toLowerCase(), xmlGreekInUnicode)
        valid = true
      } catch (Exception e) {
        System.err.println "GreekNode:verifyGreek: invalid text string ${n}"
        valid = false
      }
    } else {
      n.children().each { child ->
	valid = verifyGreek(child)
      }
    }
    return valid
  }

  /** Recursively converts a parsed node with Greek in ASCII encoding
  * into Unicode mapping of Greek.
  * @param n The parsed node to convert.
  * @param accumulatedText Previously accumulated text.
  * @returns A String of well-formed XML with text nodes
  * representing Greek in Unicode mapping.
  * @throws Exception if text node is not a valid value form
  * a GreekString object.
  */
  String getUnicodeXml(Object n, String accumulatedText)
  throws Exception {
    if (n instanceof java.lang.String) {
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

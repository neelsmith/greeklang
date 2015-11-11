package edu.holycross.shot.xml


import edu.holycross.shot.orthography.GreekString

import groovy.xml.Namespace


/** A class for working with Greek text.  A GreekNode represents a well-formed XML node with text nodes composed of string data valid for constructing a GreekString.
 */
class GreekNode {

  /** Temporary variable to delete before release version. */
  boolean debug = 0



  /* Values defining a magic element wrapping word tokens potentially including
  further markup that extraction needs to burrow through
  */

  /** If non-null, magic element must be in this namespace */
  String magicNs = ""
  /** If non-null, local name of magic word wrapping element. */
  String magicNode = ""
  /** If non-null, name of an attribute that must be present on magicNode. */
  String magicAttrName = ""
  /** If non-null, required value for magic attribute named by magicAttrName. */
  String magicAttrValue = ""


  /** The root of the XML content as a parsed groovy.util.Node */
  def parsedNode = null

  boolean xmlGreekInUnicode = ""

  GreekNode () {
  }

  /**
   * Constructs a GreekNode object from a groovy Node object.
   */
  GreekNode (groovy.util.Node n) {
    if (debug) {
      System.err.println "\nConstructing GreekNode from groovy node " + n + "\n"
    }
    parsedNode = n
  }

  /**
   * Constructs a GreekNode object from the XML representation of
   * contents, using default values for character encoding
   * and node namespace.
   * @param content A strin of well-formed XML.
   * @param True if text nodes of XML document represent GreekStrings in Unicode mapping,
   * false if text nodes represent Greek in ASCII mapping.
   * @throws Exception if content could not be parsed.
   */
  GreekNode (String content, boolean xmlUnicode) {
    try {
      parsedNode = new XmlParser().parseText(content)
    } catch (Exception e) {
      throw new Exception("GreekNode: could not parse content ${content}")
    }
    if (!parsedNode) {
      throw new Exception("GreekNode: could not parse content ${content}")
    }
    xmlGreekInUnicode = xmlUnicode
  }

  /** Recursively walks through all descendants of an XML node
   * and collects the content of text nodes.
   * @return A GreekString with the text content of the object node.
   */
  GreekString collectText() {
    return collectText(this.parsedNode,new GreekString(""),false)
  }

  /** Recursively walks through all descendants of an XML node
   * and collects the content of text nodes.
   * @param n The parsed node from which text will be extracted.
   * @return A GreekString with the text content of the object node.
   */
  GreekString collectText(groovy.util.Node n) {
    return collectText(n,new GreekString(""),false)
  }

  /** Recursively walks through all descendants of an XML node
   * and collects the content of text nodes. In handling white space,
   * XML elements are taken to mark new, white-space delimited tokens
   * except where markup identified by the magicNode() method
   * groups together a token with mixed content model.
   * @param n The parsed node from which text will be extracted.
   * @param allText The String of previously accumulated text content,
   * to which the content of any further text nodes will be added.
   * @param inWord Flag indicating whether or not we're within a "magic" node
   * with mixed content model.
   * @return A GreekString with the text content of the object node.
   */
  GreekString collectText(Object n, GreekString allText, boolean inWord) {
    if (n.getClass().getName() == "java.lang.String") {
      allText = new GreekString(allText.toString() + n, xmlGreekInUnicode)

    } else {
      /*if (magicNode(n)) {
	inWord = true
	} */
      n.children().each { child ->
	//  if (!inWord) {
	allText = new GreekString(allText.toString() + " ")
	//  }

  if (allText.toString()) {
	   allText = collectText(child, new GreekString(allText.toString()),inWord)
   } else {
     allText = collectText(child, new GreekString(""), inWord)
   }
      }
      /*  if (magicNode(n)) {
	  inWord = false
	  } */
      return allText
    }
  }



  /** Creates a String of well-formed XML with Greek text in encoding toEncoding.
   * @param n A node resulting from XmlParser's output, which could be either
   * a groovy.util.Node object or a String object.
   * @param fromEncoding Encoding used for node n.
   * @param toEncoding Encoding for result.
   * @param allText The String of previously accumulated text content,
   * to which the content of any further text nodes will be added.
   * @return A String of well-formed XML with Greek in encoding toEncoding.
   * @throws Exception if value of enc is not in encodingsList.
   */
  String transcodeXml(Object n, GreekString accumulatedText) {

    if (n.getClass().getName() == "java.lang.String") {
      /*
      switch (toEncoding) {

      if (toEncoding == "beta") {
      allText = allText + xc.getString(n).toLowerCase()
      } else {
      allText = allText + xc.getString(n).toLowerCase()
      }

        } else {
            allText += "<${n.name()}" + collectAttrs(n) + ">"
            n.children().each { child ->
                allText = transcodeXml(child, fromEncoding, toEncoding, allText)
            }
            allText+= "</${n.name()}>"
	    }
      */

      return allText
    }
  }



  /** Serializes the context of parsedNode as well-formed XML with Greek text
   * in encoding toEncoding.
   * @return A String of well-formed XML with Greek in encoding toEncoding.
   * @throws Exception if value of enc is not in encodingsList.
   */
  String transcodeXml(String toEncoding) {

    if (toEncoding in encodingList) {
      if (this.charEnc == toEncoding) {
	System.err.println "Not transcoding string:  already in target character encoding ${this.charEnc}"
	return this.toXml()
      } else {
	transcodeXml(parsedNode, this.charEnc,toEncoding, "")
      }

    } else {
      throw new Exception("transcodeXml: encoding ${toEncoding} not recognized")
    }
  }

  /** Serializes the object's parsedNode as an XML String.
   * This serialization does not include any XML or namespace declarations.
   * @return A String of well-formed XML.
   */
  String toXml() {
    return serializeNode(parsedNode, "", false)
  }

  /** Serializes the object's parsedNode as an XML String.
   * @param withDefaultNsDecl True if namespace declaration
   * should be included.
   * @return A String of well-formed XML.
   */
  String toXml(boolean withDefaultNsDecl) {
    return serializeNode(parsedNode, "", false, withDefaultNsDecl)
  }



  /* ************************************************************/
  // PRIVATE METHODS FOR FORMING XML STRINGS /////////////////////

  private String closeElement(Object n) {
    if (n.name() instanceof groovy.xml.QName)  {
      if (n.name().getPrefix().size() > 0) {
	return "</${n.name().getPrefix()}:${n.name().getLocalPart()}>"
      } else {
	return "</${n.name().getLocalPart()}>"
      }
    } else {
      return "</" + n.name() + ">"
    }
  }

  private String openElement(Object n, boolean withDefaultNs) {
    StringBuffer tag = new StringBuffer()
    if (n.name() instanceof groovy.xml.QName) {
      if (n.name().getPrefix().size() > 0) {
	if (withDefaultNs) {
	  tag.append('<?xml version="1.0" encoding="UTF-8"?>\n')
	}
	tag.append("<${n.name().getPrefix()}:${n.name().getLocalPart()}")
	if (withDefaultNs) {
	  tag.append(" xmlns='" + n.name().getNamespaceURI() + "' ")
	}
	tag.append(" xmlns:${n.name().getPrefix()}=" + '"' + n.name().getNamespaceURI() + '" ')

      } else {
	tag.append("<${n.name().getLocalPart()}")
	if (withDefaultNs) {
	  tag.append(' xmlns="' + n.name().getNamespaceURI() + '" ')
	}

      }
    } else {
      tag.append("<" + n.name())
    }
    tag.append( collectAttrs(n))
    tag.append(">")
    return tag.toString()
  }


  private String serializeNode(Object n, String allText, boolean inWord) {
    return serializeNode(n, allText, inWord, false)
  }


  /** Creates a String of well-formed XML by recursively walking the
   * descendants of groovy.util.Node.
   * @param n A node resulting from XmlParser's output, which could be either
   * a groovy.util.Node object or a String object.
   * @param allText The String of previously accumulated text content,
   * to which the content of any further text nodes will be added.
   * @return A String of well-formed XML.
   */
  private String serializeNode(Object n, String allText, boolean inWord, boolean includeRootNsDecl) {
    if (n instanceof java.lang.String) {
      allText = allText + n
    } else {
      allText += openElement(n, includeRootNsDecl)
      n.children().each { child ->
	allText += " "
      }
      allText = serializeNode(child, allText,inWord)
    }

    allText+=  closeElement(n)
    return allText
  }


  /** Creates a String representing any attributes of a given node
   * in the form key="value"
   * @param n The Node to examine.
   * @return A String with space-separated key="value" pairs.
   */
  private String collectAttrs(groovy.util.Node n) {
    StringBuffer attrStr = new StringBuffer()
    n.attributes().keySet().each { a ->
      if (a instanceof groovy.xml.QName) {
	attrStr.append(" ${a.getPrefix()}:${a.getLocalPart()}=" + '"' + n.attribute(a) + '" ')
      } else {
	attrStr.append(" ${a}=" + '"' + n.attribute(a) + '" ')
      }
    }
    return attrStr.toString()
  }

}

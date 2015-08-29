package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestSubstr extends GroovyTestCase {


  String third = 'γ"'
  String longStr = '𐅵 δ"'


  void analyzeString(String s) {
    int max = s.codePointCount(0, s.length() ) 
    println "Number code points in ${s} = " + max

    int idx = 0
    println "codept\thex\tstring\n"
    int codePoint = s.codePointAt(idx)
    def str =  new String(Character.toChars(codePoint))
    def count = 0
    while (count < max) {
      codePoint = s.codePointAt(idx)
      str =  new String(Character.toChars(codePoint))
      println "${idx}. " + codePoint + "\t(" +Integer.toHexString(codePoint) +")\t" + str + "\n"
      idx = s.offsetByCodePoints(idx,1)
      count++
    }
  }

  
  void  testLongFract() {
    println "Analyze " + third
    analyzeString(third)

    println "Analyze " + longStr
    analyzeString(longStr)
    
  }

}
package edu.holycross.shot.greekutils

/**
* An implementation of the Comparator interface that sorts Greek Strings
* in beta code according to the logic of Greek.
*/
class BetaComparator implements Comparator {
    /** Ordered map of beta-code alphabetic characters for use in comparator */
    static def betaOrder = [ 0 : 'a',
1: 'b',2:'g',3:'d',4:'e',5:'z',6:'h',7:'q',8:'i',9:'k',
10:'l',11:'m',12:'n',13:'c',14:'o',15:'p',16:'r',17:'s',18:'t',
19:'u',20:'f',21:'x',22:'y',23:'w']



    /** Compares a pair of one-character long Strings using the
    * ordered map in betaOrder.
    * @return  -1 if s1 < s2, 0 if s1 == s2, 1 if s1 > s2
    */
    private int charComp (s1,s2) {
        def mapEntry1 =   betaOrder.find {it.value == s1.toLowerCase()}
        def mapEntry2 =   betaOrder.find{it.value == s2.toLowerCase()}
        if ((!mapEntry1) || (!mapEntry2)) {
            // non-comparing character:  ignore
            // by treating as equal
            return 0
        }
        if (mapEntry1.key == mapEntry2.key) {
            return 0
        } else if (mapEntry1.key > mapEntry2.key) {
            return 1
        } else {
            return -1
        }
    }

    /** Compares two Strings in beta code.
    * @param s1 First String to compare.
    * @param s2 Second String to compare.
    * @return  -1 if s1 < s2, 0 if s1 == s2, 1 if s1 > s2
    */
    int compare(s1, s2) {
        int idx = 0
        def maxChars = 0
        if (s1.size() > s2.size()) {
            maxChars = s2.size() 
        } else {
            maxChars = s1.size()
        }
        boolean done = false
        while (!done) {
            def cComp = charComp(s1[idx],s2[idx])
            if (cComp != 0) {
                return cComp
            } else {
                idx++;
            }
            if (idx == maxChars - 1) {
                done = true
            }
        }
        // two tokens matched for all chars, but
        // if one is longer, it sorts later:
        if (s1.size() > s2.size()) {
            return 1 
        } else if (s1.size() == s2.size()) {
            return 0
        } else {
            return -1
        }
    } 
}

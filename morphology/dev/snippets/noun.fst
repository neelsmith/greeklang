% noun snippet

#include "../../build/fst/symbols.fst"

#urnchar# = a-z 0-9 _

$noun$ = <abburn>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</abburn> <abburn>{lexent}:<>\.:<>[#urnchar#]:<>+</abburn>[#stemchars#]+

$noun$


% whattogen:WHATtoANALYZE
%[a-za-z]:[A-Za-z]*

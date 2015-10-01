
MORPH=../build/fst/morphology.a


DATAFILE=$1

echo Analyzing $DATAFILE
/bin/cat $DATAFILE | /usr/bin/fst-mor $MORPH

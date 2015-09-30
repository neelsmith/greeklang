
MORPH=$1
DATAFILE=$2

echo /bin/cat $DATAFILE | /usr/bin/fst-mor $MORPH
/bin/cat $DATAFILE | /usr/bin/fst-mor $MORPH

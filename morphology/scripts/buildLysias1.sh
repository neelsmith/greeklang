#!/bin/sh


GRADLE=`which gradle`
$GRADLE -Pdataset=lysias1 clean && $GRADLE -Pdataset=lysias1 buildStems && $GRADLE -Pdataset=lysias1 fst

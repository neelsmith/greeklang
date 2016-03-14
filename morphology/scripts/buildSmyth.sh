#!/bin/sh


GRADLE=`which gradle`
$GRADLE -Pdataset=smyth clean && $GRADLE -Pdataset=smyth buildStems && $GRADLE -Pdataset=smyth fst

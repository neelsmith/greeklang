#!/bin/sh


GRADLE=`which gradle`
$GRADLE -Pdataset=pool clean && $GRADLE -Pdataset=pool buildStems && $GRADLE -Pdataset=pool fst

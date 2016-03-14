#!/bin/sh


GRADLE=`which gradle`
$GRADLE -Pdataset=attic clean && $GRADLE -Pdataset=attic buildStems && $GRADLE -Pdataset=attic fst

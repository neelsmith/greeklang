#!/bin/sh

GRADLE=`which gradle`

$GRADLE -Portho=attic fst
$GRADLE -Portho=greek fst 

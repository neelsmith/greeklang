#!/bin/sh

GRADLE=`which gradle`

$GRADLE -Portho=attic utils
$GRADLE -Portho=greek utils 

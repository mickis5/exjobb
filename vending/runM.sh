#!/bin/bash


# Add path to Randoop .jar-fil och modbat .jar-fil
. setup.sh

scala -cp "$RANDOOP_JAR:." $MODBAT_JAR RandoopModel -n=5

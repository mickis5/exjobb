#!/bin/bash


# Add path to Randoop .jar-fil och modbat .jar-fil
. setup.sh

java -cp "$RANDOOP_JAR:." javaRandoop

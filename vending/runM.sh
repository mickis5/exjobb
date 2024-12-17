#!/bin/bash


# Add path to Randoop .jar-fil och modbat .jar-fil
. setup.sh

#scala -cp "$RANDOOP_JAR:." $MODBAT_JAR RandoopModel -n=1 --log-level=debug --no-redirect-out

# Bygg klassvägen genom att samla alla JAR-filer i Scala-bibliotekskatalogen
CLASSPATH="`ls /usr/local/scala-2.11.12/lib/*.jar | tr '\n' ':'`"
CLASSPATH="${CLASSPATH}.:$RANDOOP_JAR:$MODBAT_JAR"

# Kör kommandot med modbat
java -cp "$CLASSPATH" modbat.mbt.Main RandoopModel -n=2 
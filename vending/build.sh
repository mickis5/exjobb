#!/bin/bash


# Add path to Randoop .jar-fil och modbat .jar-fil
[ -e "${RANDOOP_JAR}" ] || RANDOOP_JAR="`find ${HOME}/randoop -name 'randoop-all-4*.jar'`"
[ -e "${MODBAT_JAR}" ] || MODBAT_JAR="`find ${HOME}/modbat -name 'modbat.jar'`"



javac -cp "$RANDOOP_JAR:." $(find . -name "*.java" ! -name "VendingMBT.java")


#lyckades java??
if [ $? -eq 0 ]; then
  echo "Java-files Compiles"
else
  echo "Compilation of Java-files failed"
  exit 1
fi


scalac -cp "$RANDOOP_JAR:$MODBAT_JAR:." VendingModel.scala

# lyckades scala??
if [ $? -eq 0 ]; then
  echo "Scala-filer Compiles"
else
  echo "Compilation of Scala files failed"
  exit 1
fi

# Steg 3: Kompilera VendingMBT.java
javac  VendingMBT.java

# VendingMBT.java 
if [ $? -eq 0 ]; then
  echo "VendingMBT.java"
else
  echo "VendingMBT.java failed!"
  exit 1
fi


echo "Finished!"

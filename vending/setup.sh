#!/bin/sh

# Try to auto-detect randoop.jar and modbat.jar
[ -e "${RANDOOP_JAR}" ] || RANDOOP_JAR="`find ${HOME}/randoop -name 'randoop-all-4*.jar'`"
[ -e "${MODBAT_JAR}" ] || MODBAT_JAR="`find ${HOME}/modbat -name 'modbat.jar'`"

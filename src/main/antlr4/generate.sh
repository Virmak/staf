#!/bin/bash

antlr4 Staf.g4 -package com.sparkit.staf -visitor
javac  -classpath /usr/local/lib/antlr-4.8-complete.jar Staf*.java
#grun Staf file -gui script.staf
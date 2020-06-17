#!/bin/bash

antlr4 Staf.g4 -visitor
javac  -classpath /usr/local/lib/antlr-4.8-complete.jar Staf*.java
grun Staf staf_file -gui script.staf
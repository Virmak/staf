#!/bin/sh
zip -r build.zip build
scp -r build docker@192.168.1.203:/home/docker/staf-framework/

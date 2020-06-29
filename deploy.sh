#!/bin/sh
scp  build/build.zip springboot@192.168.1.83:/home/springboot/staf
ssh springboot@192.168.1.83 '/home/springboot/staf/deploy-containers.sh'
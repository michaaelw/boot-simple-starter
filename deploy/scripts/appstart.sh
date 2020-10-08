#!/usr/bin/env bash

cd /home/app/server
#export SPRING_CONFIG_NAME=asset
#export SPRING_CONFIG_LOCATION=/home/app/server/
java -jar -Dserver.port=8080 *.jar -Dspring.config.additional-location=file:/home/app/server/config/database.properties,file:/home/app/server/config/environment.properties > asset.out 2> asset.err < /dev/null &

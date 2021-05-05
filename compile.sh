#!/bin/sh
appname=$(cat pom.xml | grep \<artifactId\> | head -1 | cut -d \> -f 2 | cut -d \< -f 1)
appversion=$(cat pom.xml | grep \<version\> | head -1 | cut -d \> -f 2 | cut -d \< -f 1)
docker run -i -v /var/run/docker.sock:/var/run/docker.sock \
  -v $(pwd):/src \
  -v $HOME/.m2:/root/.m2 \
  -e DOCKER_IMAGE="heasyapp/$appname:$appversion" heasyapp/graalvm-builder:latest
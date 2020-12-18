#!/bin/sh
echo "########## START $OSTYPE" ##########"

echo "********************************************************"
echo "Generate binary files for service api"
echo "********************************************************"

./api/gradlew bootJar

echo "********************************************************"
echo "Run compose docker to create environments"
echo "********************************************************"

docker-compose up -d --build
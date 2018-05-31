#!/bin/bash

echo "Deployment OLSystem...";


if [ -z "$TOMCAT" ]
then
    echo "\nTomCat isn't installed or isn't setting environment variable TOMCAT.";
    echo "If TomCat isn't installed, use 'apt-get install tomcat8'.";
    echo "If environment variable 'TOMCAT' isn't setting, use 'export TOMCAT=\"path_to_tomcat\"', or add variable in file /etc/environment.";
    exit 0;
fi


TOMCAT_WEBAPPS=${TOMCAT}/webapps
TOMCAT_CONFIG=${TOMCAT}/conf/server.xml
TOMCAT_START=${TOMCAT}/bin/startup.sh
WAR_FILE=OLSystem/target/OLSystem.war


if [ ! -r "$WAR_FILE" ]
then
    echo "$WAR_FILE is missing. Download it and run this again to deploy it." ;
else
    cp ${WAR_FILE} ${TOMCAT_WEBAPPS}
    sed -i s/8080/9090/g ${TOMCAT_CONFIG}
    ${TOMCAT_START}
fi
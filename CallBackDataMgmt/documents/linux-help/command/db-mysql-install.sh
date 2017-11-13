#!/bin/bash

rootDir=.
libDir=$rootDir/libs/*;
classesDir=$rootDir/classes;
mainClass=com.app.buzz.WebServer.dbinstall.MysqlDbInstall;

classPathValue=$classesDir;
for d in $libDir
  do
    classPathValue=$classPathValue:$d;
  done

#echo 'classPahtValue is ' + $classPathValue;

java -classpath $classPathValue $mainClass &


#!/bin/bash

cd ../metridoc-grails
./buildAll.sh

cd ../metridoc-app
./grailsw --refresh-dependencies --non-interactive tA :unit --stacktrace 
./grailsw --refresh-dependencies --non-interactive maven-install --stacktrace
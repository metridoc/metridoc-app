#!/bin/bash

./grailsw --refresh-dependencies --non-interactive tA :unit --stacktrace 
./grailsw --refresh-dependencies --non-interactive maven-install --stacktrace
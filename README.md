This is a basic template / container for the view layer of metridoc.  All of the metridoc projects are grails plugins
and this application represents starting point to use these components.  Although this readme should help you get started, 
more details about MetriDoc software are available at the MetriDoc [wiki](https://github.com/metridoc/metridoc-wiki/wiki).  
For the most part, MetriDoc is an api / scripting tool to migrate data and the view part is an optional component to 
view / download that data.  If you want to use any of the view components that have been created for MetriDoc, this is the 
place to start.

#### Getting Started

This template represents a default grails application that only contains the `metridoc-core` plugin.  The template is 
actually a running application.  No MetriDoc applications are installed, so by itself it doesn't do
anything particularily interesting besides configuring security.  

Please follow the installation guide at this link to install and run the app:
https://github.com/metridoc/metridoc-grails

In order to run the application in development mode with your local instance of metridoc-grails, please have metridoc-grails repo in the same directory as metridoc-app is. Then in metridoc-app folder, navigate to /grails-app/conf/BuildConfig.groovy. In this file, uncomment the 5 lines that say:
```groovy
grails.plugin.location."metridoc-core" = "../metridoc-grails/metridoc-grails-core" 
grails.plugin.location."metridoc-illiad" = "../metridoc-grails/metridoc-grails-illiad" 
grails.plugin.location."metridoc-funds" = "../metridoc-grails/metridoc-grails-funds" 
grails.plugin.location."metridoc-bd" = "../metridoc-grails/metridoc-grails-bd" 
grails.plugin.location."metridoc-rid" = "../metridoc-grails/metridoc-grails-rid"
```
These lines will connect your application with your local instance of metridoc-grails instead of the remote version. You should build the application again after you uncommented these lines.

You should see a simple home page listing installed applications (which there are none).  You can log in as admin with
user name `admin` and password `password` to see the admin components.  At this point the application is running on an
in memory database, so any changes you make will be lost on a restart.  And given the default password, very insecure.

For general depoyment you have two options, you can either run `./grailsw run-war` which fires up the application on a
Tomcat server, or run `./grailsw war` to create a war archive of the application which can be deployed to your favorite 
servlet container.  MetriDoc components have been tested on Jetty and Tomcat.  Tried and failed to get the application to 
work on Glassfish.










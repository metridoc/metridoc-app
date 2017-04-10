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

You should see a simple home page listing installed applications (which there are none).  You can log in as admin with
user name `admin` and password `password` to see the admin components.  At this point the application is running on an
in memory database, so any changes you make will be lost on a restart.  And given the default password, very insecure.

For general depoyment you have two options, you can either run `./grailsw run-war` which fires up the application on a
Tomcat server, or run `./grailsw war` to create a war archive of the application which can be deployed to your favorite 
servlet container.  MetriDoc components have been tested on Jetty and Tomcat.  Tried and failed to get the application to 
work on Glassfish.










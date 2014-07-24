FileCheck
=========

FileCheck allows quick testing of the compliance of code supplied in a ZIP, JAR or WAR file with defined criteria.

Organisation
------------
Filecheck is organised into four modules. Common functionality is abstracted into `filecheck-core`, which the following modules depend on:

+ `filecheck-app` module contains a Swing GUI for desktop use.
+ `filecheck-util` is a very basic command-line utility that exposes the main functionality.
+ `filecheck-web` is a standard Java web app to be packaged as a WAR file.

The parent `pom.xml` will build all four projects.

License
------
FileCheck is licensed under GPL v3.

Deployment
----------
The `filecheck-web` module is designed to run on Apache Tomcat. 
However, it should run on any other Java web app server with no/minor modifications.

The `filecheck-web` module may be deployed automatically using the Deploy To Web custom goal. To use this, fill in the following properties for your Tomcat server in your maven settings.xml: `filecheck-web.deploy.username`, `filecheck-web.deploy.password`, `filecheck-web.deploy.url`
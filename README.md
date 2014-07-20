FileCheck
=========

FileCheck allows quick testing of the compliance of code supplied in a ZIP, JAR or WAR file with defined criteria.

Organisation
------------
Filecheck is organised into three modules. Common functionality is abstracted into `filecheck-core`, which both the `filecheck-web` and `filecheck-app` modules depend on. The `filecheck-app` module contains a Swing GUI for desktop use, as well as a command-line utility. The `filecheck-web` module contains a standard Java web app to be packaged as a WAR file. The parent `pom.xml` will build all three projects.

License
------
FileCheck is licensed under GPL v3.

Please note that the headers of some source files may not have been updated to reflect this as yet.

# material-design-lite-gwt
[![Build Status](https://travis-ci.org/ilyes4j/material-design-lite-gwt.svg?branch=dev)](https://travis-ci.org/ilyes4j/material-design-lite-gwt)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.ilyes4j/material-design-lite-gwt.svg)](https://repo1.maven.org/maven2/com/github/ilyes4j/material-design-lite-gwt-lib/0.1.0/)
[![License](https://img.shields.io/badge/License-Apache_2-orange.svg)](https://raw.githubusercontent.com/ilyes4j/material-design-lite-gwt/dev/LICENSE)
[![Issues](https://img.shields.io/github/issues/ilyes4j/material-design-lite-gwt.svg)](https://github.com/ilyes4j/material-design-lite-gwt/issues)


> **mdl-gwt** is a Java wrapper enabling [material design lite](http://getmdl.io) look and feel in GWT projects.

# Showcases
## 1. Last build
You can take a peek at the upcoming release being cooked [over here](http://ilyes4j.github.io/material-design-lite-gwt/snapshot/).
## 2. Releases
* [version 0.1.0](http://ilyes4j.github.io/material-design-lite-gwt/0.1.0/)

# Getting started
## 1. Setup a GWT project
It is assumed that you already setup a GWT project. If not, this  [tutorial](http://www.gwtproject.org/gettingstarted.html) might be of help.

## 2. Setup the host page
Include [material design lite](http://getmdl.io/started/) in your host page.

```html
<head>
  <link rel="stylesheet" href="https://code.getmdl.io/1.1.1/material.blue_grey-red.min.css">

  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <script src="https://storage.googleapis.com/code.getmdl.io/1.1.1/material.min.js"></script>
</head>
```

## 3. Include the dependency in your pom.xml
Include the _**mdl-gwt**_ library as a dependency in your Maven project.

```xml
<dependency>
  <groupId>com.github.ilyes4j</groupId>
  <artifactId>material-design-lite-gwt-lib</artifactId>
  <version>0.1.0</version>
  <scope>provided</scope>
</dependency>
```

## 4. Import the library in your GWT module

Finally, make sure to inherit the library GWT module in the GWT module of the project.
```xml
<module>
  <inherits name="com.github.ilyes4j.gwt.mdl.Mdl" />
</module>
```

## License
Mohamed ilyes Dimassi, 2016. Licensed under the [Apache-2](https://github.com/ilyes4j/material-design-lite-gwt/blob/dev/LICENSE) license.

# material-design-lite-gwt
[![Build Status](https://travis-ci.org/ilyes4j/material-design-lite-gwt.svg?branch=dev)](https://travis-ci.org/ilyes4j/material-design-lite-gwt)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.ilyes4j/material-design-lite-gwt.svg)](https://repo1.maven.org/maven2/com/github/ilyes4j/material-design-lite-gwt-lib/0.1.0/)
[![License](https://img.shields.io/badge/License-Apache_2-orange.svg)](https://raw.githubusercontent.com/ilyes4j/material-design-lite-gwt/dev/LICENSE)
[![Issues](https://img.shields.io/github/issues/ilyes4j/material-design-lite-gwt.svg)](https://github.com/ilyes4j/material-design-lite-gwt/issues)


> [mdl-gwt](http://ilyes4j.github.io/material-design-lite-gwt/components/components.html) is a Java wrapper enabling [material design lite](http://getmdl.io) look and feel in GWT projects.

# Showcase
You can explore the available set of components  [here](http://ilyes4j.github.io/material-design-lite-gwt/components/components.html).

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

# Documentation
* In the  [showcase](http://ilyes4j.github.io/material-design-lite-gwt/components/components.html) there is a series of code snippets demonstrating on how the component can be used.
* The [Javadoc](http://ilyes4j.github.io/material-design-lite-gwt/apidocs/) for the library is also available.

## License
Mohamed ilyes Dimassi, 2016. Licensed under the [Apache-2](https://github.com/ilyes4j/material-design-lite-gwt/blob/dev/LICENSE) license.

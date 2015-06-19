Tesseract-API
=============
This project provides a JNI wrapper for Tesseract OCR Library.

Building on Travis
==================
[![Build Status](https://travis-ci.org/apanimesh061/Tesseract-API.svg)](https://travis-ci.org/apanimesh061/Tesseract-API)

Building Locally
================
Dependencies: `automake`, `gcc`

```shell
cd Tesseract-API
mvn clean install
```

This will build all C++ dependencies for the current platform and bundle them into a JAR file.

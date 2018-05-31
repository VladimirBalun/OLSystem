#!/bin/bash

cd src
mvn install

cd ..
cd ProgChecker
mkdir build
cd build
cmake ..

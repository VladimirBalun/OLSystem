echo off
cd OLSystem 
@mvn install

cd ..
cd ProgChecker
mkdir build
cd build
cmake ..



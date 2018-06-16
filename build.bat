echo off

cd OLSystem 
mvn install

cd ProgChecker
mkdir build
cd build
cmake ..
cd .. 
cd ..

cd Database
mysql -u root -padmin OLSystem < database.sql
#!/bin/bash


echo "Check for the necessary languages(at the moment OLSystem supports C++, C and Python) in your system for OLSystem(progChecker)..."
SUPPORTING_LANGUAGES="" 


echo ""
echo "Python language is checking..."
if ! [ -x "$(command -v python)" ]; 
then
  	echo -n "Python language isn't installed. Do you want to install Python language?[y/n] " 
	read PYTHON_INSTALATION
	if [ "${PYTHON_INSTALATION}" = "y" ] || [ "${PYTHON_INSTALATION}" = "Y" ];
	then
		echo "Installation of python language..."
		sudo apt-get install python
		echo " - Python language was installed."
		SUPPORTING_LANGUAGES="${SUPPORTING_LANGUAGES} Python"
	fi
else
	echo " - Python language is installed."
	SUPPORTING_LANGUAGES="${SUPPORTING_LANGUAGES} Python"
fi


echo ""
echo "C++ and C languages are checking..."
if ! [ -x "$(command -v gcc)" ]; 
then
  	echo -n "C and C++ languages aren't installed. Do you want to install C++ and C languages?[y/n] " 
	read C_CPP_INSTALATION
	if [ "${C_CPP_INSTALATION}" = "y" ] || [ "${C_CPP_INSTALATION}" = "Y" ];
	then
		echo "Installation of C++ and C languages..."
		sudo apt-get install build-essential
		echo " - C++ and C languages were installed."
		SUPPORTING_LANGUAGES="${SUPPORTING_LANGUAGES} C++ C"
	fi
else
	echo " - C++ and C languages are installed."
	SUPPORTING_LANGUAGES="${SUPPORTING_LANGUAGES} C++ C"
fi

echo ""
echo "Installed languages: [${SUPPORTING_LANGUAGES} ]. You can use it in OLSystem or only for progChecker."

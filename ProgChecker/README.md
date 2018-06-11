## About ProgChecker

ProgChecker - cross-platform separate module of OLSystem, that performs the check of the participants' programs in different programming langyages.
The application is a server, that accepts requests for checking task. The programs are checked by multiple 
programs with different test data for it. This is necessary in order to exclude the possibility of the 
participant being able to adjust a deliberately correct answer. In order to send the program for verification, 
you need to cram the request, which will consist of the text of the program and the test data for it. As communication 
with the OLSystem, the JSON format is used.

##### Example request 

    "{
        'testData' : [
            {
                'outputData' : '5',
                'inputData' : '5'
            },
            {
                 'outputData' : '567',
                 'inputData' : '567'
            },
        ],
        'textProgram' : '#include <iostream>
                       
                        int main() 
                        {
                             int tmpVar = 0;
                             std::cin >> tmpVar;
                             std::cout << tmpVar << std::endl;
                             return EXIT_SUCCESS;
                        }'
    }"

After checking the program, the application sends the result code:

- 100 - Successful program execution
- 101 - Error while compiling the program (for compiled languages)
- 102 - Error during program execution
- 103 - Security error related to the application and the entire system
- 104 - Unknown error

##### Example response

    { "resultChecking" : "100" }

At the moment, ProgChecker supports checking programs for the following languages:

- C/C++
- Java
- Python

But other languages will be added soon. 

## How to build ProgChecker

    cd ProgChecker
    mkdir build
    cd build 
    cmake ..
    
After that you can use this application. For work with the application, your computer must be 
installed boost library. It should be noted that ProgChecker isn't required to be used together 
with the OLSystem. You can install it on the server and use a completely different system with 
the ProgChecker.

## How to start ProgChecker

    usage: ProgChecker [PROGRAMMING_LANGUAGE] [COMPILER_OR_INTERPRETER] [ADDRESS] [PORT]
    
    This program checks programs in different programming languages.
    
    arguments:
      PROGRAMMING_LANGUAGE
            name language language for programs(Cpp, C, Java or Python)
      COMPILER_OR_INTERPRETER
            name compiler or interpreter for selected language supported by your OS(gcc, g++, javac, python, clang etc)


#ifndef _PROGRAM_H
#define _PROGRAM_H

#include <string>
#include <cstring>
#include <vector>
#include <iostream>
#include <memory>

#include "Data/Entity/TestData.h"
#include "EResultsChecking.h"
#include "Checking/Compilers/CCompiler.h"
#include "Checking/Compilers/CppCompiler.h"

class Program
{
public:
    Program(std::string nameProgram, std::string textProgram):
            _nameProgram(std::move(nameProgram)), _textProgram(std::move(textProgram)) {}
    static void setLanguageForPrograms(const char* lang);
    int checkProgram(std::vector<std::shared_ptr<TestData>>& testData);
private:
    int checkCProgram(std::vector<std::shared_ptr<TestData>>& testData);
    int checkCppProgram(std::vector<std::shared_ptr<TestData>>& testData);
    int checkJavaProgram(std::vector<std::shared_ptr<TestData>>& testData);
    int checkPythonProgram(std::vector<std::shared_ptr<TestData>>& testData);
private:
    std::string _nameProgram;
    std::string _textProgram;
private:
    static inline const char* CURR_LANGUAGE;
};

#endif // _PROGRAM_H

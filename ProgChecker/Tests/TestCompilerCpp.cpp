#include "Checking/Compilers/CppCompiler.h"

#define BOOST_TEST_MODULE TestCompilerCpp

#include <boost/test/unit_test.hpp>
#include <string>

BOOST_AUTO_TEST_CASE(failedCompilation)
{
    std::string nameFile = "/home/vova/main";
    std::string textProgram = "Incorrect Cpp syntax";
    Compilers::CppCompiler compiler(nameFile, textProgram);
    bool resultCompilation = compiler.compileProgram();
    BOOST_CHECK_EQUAL(resultCompilation, false);
}


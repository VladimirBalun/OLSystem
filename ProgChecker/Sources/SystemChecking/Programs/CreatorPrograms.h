#ifndef _CREATOR_PROGRAMS_H
#define _CREATOR_PROGRAMS_H

#include <boost/process.hpp>

#include "IProgram.h"
#include "Utils/Logger.h"
#include "Interpreters/Python.h"
#include "Compilers/CppC.h"
#include "Compilers/Java.h"
#include "Exceptions/SystemChecking/NonExistLanguageException.h"
#include "Exceptions/SystemChecking/NonExistProgramException.h"

namespace SystemChecking
{

    class CreatorPrograms
    {
    public:
        typedef std::unique_ptr<IProgram> UPtrIProgram;
        UPtrIProgram createCompilerOrInterpreterForLanguage(const std::string& nameLanguage, const std::string& nameProgram);
    private:
        bool checkExistingLanguage(const std::string &nameLanguage);
        bool checkExistingProgramForLanguage(const std::string &nameProgram);
    private:
        const char* __c_language = "C";
        const char* __cpp_language = "Cpp";
        const char* __java_language = "Java";
        const char* __python_language = "Python";
    };

}

#endif

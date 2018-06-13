#ifndef _CREATOR_PROGRAMS_H_
#define _CREATOR_PROGRAMS_H_

#include <boost/process.hpp>

#include "Utils/Logger.h"
#include "Interpreters/Python.h"
#include "Compilers/CppC.h"
#include "Exceptions/SystemChecking/NonExistLanguageException.h"
#include "Exceptions/SystemChecking/NonExistProgramException.h"

namespace SystemChecking
{

    /**
     * The class needs for creating compiler or interpreter
     * for selected language. It creates compiler or interpreter
     * by language name.
     */
    class CreatorPrograms
    {
        const char* __c_language = "C";
        const char* __cpp_language = "Cpp";
        const char* __python_language = "Python";
    public:
        typedef std::unique_ptr<IProgram> UPtrIProgram;
        UPtrIProgram createCompilerOrInterpreterForLanguage(const std::string& nameLanguage, const std::string& nameProgram);
    private:
        bool checkExistingLanguage(const std::string &nameLanguage);
        bool checkExistingProgramForLanguage(const std::string &nameProgram);
    };

}

#endif
#ifndef _CREATOR_PROGRAMS_H
#define _CREATOR_PROGRAMS_H

#include <boost/process.hpp>

#include "IProgram.h"
#include "Utils/Logger.h"
#include "Interpreters/Python.h"
#include "Interpreters/IInterpreter.h"

namespace SystemChecking
{

    class CreatorPrograms
    {
    public:
        typedef std::unique_ptr<IProgram> UPtrIProgram;
        bool checkCorrectnessLanguage(const std::string &nameLanguage);
        bool checkExistingProgramForLanguage(const std::string &nameProgram);
        UPtrIProgram createCompilerOrInterpreterForLanguage(const std::string& nameLanguage, const std::string& nameProgram);
    private:
        std::vector<std::string> _supportingLanguages = {"Java", "CppC", "C", "Python"};
    };

}

#endif

#include "System.h"

namespace SystemChecking
{

    System::System(const std::string& nameLanguage, const std::string& nameProgram)
    {
        static CreatorPrograms creatorPrograms;
        if (!creatorPrograms.checkCorrectnessLanguage(nameLanguage))
        {
            throw Exceptions::SystemCheckingException("Incorrect language. Language \"" + nameLanguage + "\" doesn't support by ProgChecker.");
        }
        if (!creatorPrograms.checkExistingProgramForLanguage(nameProgram))
        {
            throw Exceptions::SystemCheckingException("Incorrect program. Compiler or interpreter \"" + nameProgram + "\" doesn't install.");
        }
        _checkingProgram = creatorPrograms.createCompilerOrInterpreterForLanguage(nameLanguage, nameProgram);
    }

    int System::checkTask(const UPtrTask& task)
    {
        return _checkingProgram->checkTask(task);
    }

}
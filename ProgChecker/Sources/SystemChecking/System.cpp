#include "System.h"

namespace SystemChecking
{

    /**
     * The constructor of this class. Here compiler or interpreter is created for checking the tasks
     * @param nameLanguage name of the language for checking the programs on it.
     * @param nameProgram name of the compiler or interpreter for current language.
     * @throw Exceptions::SystemCheckingException throws exception if language doesn't support
     * by ProgChceker, or compiler and interpreter absent in OS
     */
    System::System(const std::string& nameLanguage, const std::string& nameProgram)
    {
        try
        {
            CreatorPrograms creatorPrograms;
            _checkingProgram = creatorPrograms.createCompilerOrInterpreterForLanguage(nameLanguage, nameProgram);
        }
        catch (Exceptions::NonExistLanguageException& e)
        {
            throw Exceptions::SystemCheckingException(e.what());
        }
        catch (Exceptions::NonExistProgramException& e)
        {
            throw Exceptions::SystemCheckingException(e.what());
        }
    }

    /**
     * The override method of ISystem. It transfers control to
     * the created compiler or interpreter fo checking task.
     * @param task task for checking.
     * @return result of checking current task.
     * @see ISystem
     */
    EResultChecking System::checkTask(const UPtrTask& task)
    {
        return _checkingProgram->checkTask(task);
    }

}
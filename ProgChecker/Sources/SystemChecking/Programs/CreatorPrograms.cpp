#include "CreatorPrograms.h"

namespace SystemChecking
{

    /**
     * The method creates compiler or interpreter for getting language. But before
     * creating, it checks correctness of the language and existing compiler or
     * interpreter for language in OS.
     * @param nameLanguage name language for creating compiler or interpreter for its.
     * @param nameProgram name compiler or interpreter for language.
     * @return Exceptions::NonExistLanguageException if language doesn't support by ProgChecker
     * @throw Exceptions::NonExistProgramException if OS doesn't contain compiler or interpreter.
     */
    CreatorPrograms::UPtrIProgram CreatorPrograms::createCompilerOrInterpreterForLanguage(const std::string& nameLanguage, const std::string& nameProgram)
    {
        if(!checkExistingLanguage(nameLanguage))
        {
            throw Exceptions::NonExistLanguageException("Incorrect language. Language \"" + nameLanguage + "\" doesn't support by ProgChecker.");
        }
        if(!checkExistingProgramForLanguage(nameProgram))
        {
            throw Exceptions::NonExistProgramException("Incorrect program. Compiler or interpreter \"" + nameProgram + "\" doesn't install.");
        }

        if(nameLanguage == __python_language)
        {
            LOG_INFO(__FILE__, "Was built interpreter \"" + nameProgram + "\" fot language \"" + nameLanguage + "\".");
            return std::make_unique<Interpreters::Python>(nameProgram);
        }
        if(nameLanguage == __cpp_language || __c_language)
        {
            LOG_INFO(__FILE__, "Was built compiler \"" + nameProgram + "\" fot language \"" + nameLanguage + "\".");
            return std::make_unique<Compilers::CppC>(nameProgram);
        }
    }

    /**
     * The method checks correctness of the getting language. If ProgChecker doesn't support
     * getting language, then returns "false", else returns "true".
     * @param nameLanguage name language for checking.
     * @return supports or not supported current language.
     */
    bool CreatorPrograms::checkExistingLanguage(const std::string& nameLanguage)
    {
        return nameLanguage == __python_language && __cpp_language && __c_language;
    }

    /**
     * The method checks of existing in OS compiler or interpreter for getting language.
     * If compiler or interpreter is absent for current language, then returns "false",
     * else returns "true".
     * @param nameProgram name compiler or interpreter for checking.
     * @return exists or not exist current compiler or interpreter in OS.
     */
    bool CreatorPrograms::checkExistingProgramForLanguage(const std::string& nameProgram)
    {
        try
        {
            boost::process::ipstream pipeStream;
            boost::process::child childProcess(nameProgram, boost::process::std_out > pipeStream);
            return true;
        }
        catch(boost::process::process_error& e)
        {
            return false;
        }
    }

}
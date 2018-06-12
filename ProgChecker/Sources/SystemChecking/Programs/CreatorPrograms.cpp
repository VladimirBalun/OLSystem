#include "CreatorPrograms.h"

namespace SystemChecking
{

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
        if(nameLanguage == __java_language)
        {
            LOG_INFO(__FILE__, "Was built compiler \"" + nameProgram + "\" fot language \"" + nameLanguage + "\".");
            //return std::make_unique<Compilers::Java>(nameProgram);
        }
    }

    bool CreatorPrograms::checkExistingLanguage(const std::string& nameLanguage)
    {
        return nameLanguage == __python_language || __cpp_language || __c_language || __java_language;
    }

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
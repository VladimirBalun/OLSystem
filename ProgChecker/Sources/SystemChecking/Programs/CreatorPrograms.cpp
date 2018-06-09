#include "CreatorPrograms.h"

namespace SystemChecking
{

    bool CreatorPrograms::checkCorrectnessLanguage(const std::string &nameLanguage)
    {
        for (const auto &language : _supportingLanguages)
        {
            if (language == nameLanguage)
            {
                return true;
            }
        }
        return false;
    }

    bool CreatorPrograms::checkExistingProgramForLanguage(const std::string &nameProgram)
    {
        try
        {
            boost::process::ipstream pipeStream;
            boost::process::child childProcess(nameProgram, boost::process::std_out > pipeStream);
            return true;
        }
        catch(boost::process::process_error &e)
        {
            return false;
        }
    }

    CreatorPrograms::UPtrIProgram CreatorPrograms::createCompilerOrInterpreterForLanguage(const std::string& nameLanguage, const std::string &nameProgram)
    {
        LOG_INFO(__FILE__, "Was built interpreter \"" + nameProgram + "\" fot language \"Python\".");
        return std::make_unique<Interpreters::Python>(nameProgram);
    }

}


#include "Languages.h"

bool Languages::checkEnteringLanguage(const std::string& lang)
{
    for (auto l : _languages)
    {
        if (l == lang)
            return true;
    }
    return false;
}

bool Languages::checkLanguageOnPC(const std::string& lang)
{
    std::string command;
    if (lang == "Java")
    {
        command = "java";
    }
    if (lang == "C" || lang == "Cpp")
    {
        command = "gcc";
    }
    if (lang == "Python")
    {
        command = "python";
    }
    try
    {
        boost::process::ipstream pipeStream;
        boost::process::child childProcess(command, boost::process::std_out > pipeStream);
        return true;
    }
    catch(boost::process::process_error &e)
    {
        return false;
    }
}

std::vector<std::string> Languages::getAllSupportingLanguages() const
{
    return _languages;
}
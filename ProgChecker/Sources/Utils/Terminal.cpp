#include "Terminal.h"

namespace Utils
{

    /**
     * The static function for running program without input data for it.
     * @param command command for running program.
     * @return successful or unsuccessful completion of the program.
     */
    bool Terminal::runCommand(const std::string &command)
    {
        LOG_DEBUG(__FILE__, "Request on running command: " + command);
        try
        {
            boost::process::ipstream errStream;
            std::string errorMessage;
            boost::process::child process(command, boost::process::std_err > errStream);
            errStream >> errorMessage;
            process.terminate();
            std::cout << "Message: " << errorMessage << std::endl;
            return errorMessage.empty();
        }
        catch (std::exception& e)
        {
            LOG_WARNING(__FILE__, e.what());
            return false;
        }
    }

    /**
     * The static function for running program with input data for it.
     * @param command command for running program.
     * @param inputData input data for the program.
     * @return output of the program.
     */
    std::string Terminal::runCommand(const std::string& command, const std::string& inputData)
    {
        LOG_DEBUG(__FILE__, "Request on running command: " + command + " with input data: " + inputData);
        try
        {
            boost::process::opstream inStream;
            boost::process::ipstream outStream;
            std::string outputProgram;
            boost::process::child process(command, boost::process::std_out > outStream, boost::process::std_in < inStream);
            inStream << inputData << std::endl;
            outStream >> outputProgram;
            process.terminate();
            return outputProgram;
        }
        catch (std::exception& e)
        {
            LOG_WARNING(__FILE__, e.what());
            return "";
        }
    }

}
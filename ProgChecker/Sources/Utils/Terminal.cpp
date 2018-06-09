#include "Terminal.h"

namespace Utils
{

    bool Terminal::runCommand(const std::string &command)
    {
        LOG_DEBUG(__FILE__, "Request on running command: " + command);
        boost::process::ipstream errStream;
        std::string errorMessage;
        boost::process::child process(command, boost::process::std_err > errStream);
        errStream >> errorMessage;
        process.terminate();
        return errorMessage.empty();
    }

    std::string Terminal::runCommand(const std::string& command, const std::string& inputData)
    {
        LOG_DEBUG(__FILE__, "Request on running command: " + command + " with input data: " + inputData);
        boost::process::opstream inStream;
        boost::process::ipstream outStream;
        std::string outputProgram;
        boost::process::child process(command, boost::process::std_out > outStream, boost::process::std_in < inStream);
        inStream << inputData << std::endl;
        outStream >> outputProgram;
        process.terminate();
        return outputProgram;
    }

}


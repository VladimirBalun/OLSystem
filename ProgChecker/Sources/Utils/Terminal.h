#ifndef _TERMINAL_H_
#define _TERMINAL_H_

#include <iostream>
#include <boost/process.hpp>

#include "Utils/Logger.h"

namespace Utils
{

    /**
     * The class for running commands in the terminal for LINUX/OSX
     * and the command line for WINDOWS.
     */
    struct Terminal
    {
        static bool runCommand(const std::string& command);
        static std::string runCommand(const std::string& command, const std::string& inputData);
    };

}

#endif
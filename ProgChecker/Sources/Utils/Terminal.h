#ifndef _TERMINAL_H_
#define _TERMINAL_H_

#include <string>
#include <iostream>
#include <boost/process.hpp>

#include "Utils/Logger.h"

namespace Utils
{

    struct Terminal
    {
        static bool runCommand(const std::string& command);
        static std::string runCommand(const std::string& command, const std::string& inputData);
    };

}

#endif

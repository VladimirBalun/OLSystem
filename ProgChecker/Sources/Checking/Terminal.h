#ifndef _TERMINAL_H
#define _TERMINAL_H

#include <string>
#include <iostream>
#include <boost/process.hpp>

#include "Utils/Logger.h"

struct Terminal
{
    bool runCommand(const std::string& command);
    std::string runCommand(const std::string& command, const std::string& inputData);
};


#endif // _TERMINAL_H

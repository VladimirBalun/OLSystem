#ifndef _FILESYSTEM_H_
#define _FILESYSTEM_H_

#include <string>
#include <fstream>
#include <iostream>

#include "Logger.h"

namespace Utils
{

    std::string read_file(const std::string& pathFile);
    bool create_source_file(const std::string &nameFile, const std::string &text);

}

#endif

#ifndef _FILESYSTEM_H_
#define _FILESYSTEM_H_

#include <string>
#include <fstream>
#include <iostream>

#include "Logger.h"

namespace Utils
{

    const std::string USER_DIRECTORY = getenv("USERPROFILE");

    std::string read_file(const std::string& pathFile);
    bool create_source_file(const std::string& nameFile, const std::string& text);
    void remove_sources_and_exe_files(const std::string& nameFile, ...);

}

#endif

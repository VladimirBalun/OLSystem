#ifndef _FILESYSTEM_H_
#define _FILESYSTEM_H_

#include <cstdio>
#include <string>
#include <fstream>
#include <iostream>

#include "Logger.h"

namespace Utils
{

    const std::string USER_DIRECTORY = getenv("USERPROFILE");

    bool create_source_file(const std::string& nameFile, const std::string& text);
    void remove_source_and_exe_files(const std::string& sourceFile, const std::string& exeFile = "");

}

#endif

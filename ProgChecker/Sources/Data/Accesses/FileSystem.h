#ifndef _FILESYSTEM_H_
#define _FILESYSTEM_H_

#include <string>
#include <fstream>
#include <iostream>

bool create_file(const std::string &nameFile, const std::string &text);
bool remove_files(const std::string &nameFile, ...);

#endif // _FILESYSTEM_H

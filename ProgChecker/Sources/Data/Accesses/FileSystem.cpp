#include <boost/filesystem.hpp>
#include "FileSystem.h"

bool create_file(const std::string &nameFile, const std::string &text)
{
    std::ofstream out(nameFile);
    if (out.is_open())
    {
        out << text;
        out.close();
        return true;
    }
    else
    {
        return false;
    }
}

/**
 *
 * @return
 */
bool remove_files(const std::string &nameFile, ...)
{

}

/**
 *
 * @param textXMLFile
 * @return
 */
std::vector<std::string> parse_XML(const std::string &textXMLFile)
{
    return std::vector<std::string>();
}

/**
 *
 */
void generate_XML()
{

}

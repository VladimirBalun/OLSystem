#include "FileSystem.h"

/**
 *
 * @param pathFile
 * @return
 */
std::string Utils::read_file(const std::string& pathFile)
{
    std::ifstream in(pathFile);
    if (in.is_open())
    {
        std::string buff(std::istreambuf_iterator<char>(in.rdbuf()), std::istreambuf_iterator<char>());
        in.close();
        return buff;
    }
    else
    {
        LOG_WARNING(__FILE__, "File \"" + pathFile + "\" not found.");
        return "";
    }
}

/**
 *
 * @param nameFile
 * @param text
 * @return
 */
bool Utils::create_source_file(const std::string& nameFile, const std::string& text)
{
    std::string userDirectory = getenv("USERPROFILE");
    #ifdef _WIN32
        std::string pathFile = userDirectory + "\\" + nameFile;
    #else
        std::string pathFile = userDirectory + "/" + nameFile;
    #endif

    std::ofstream out(pathFile);
    if (out.is_open())
    {
        out << text;
        out.close();
        return true;
    }
    else
    {
        LOG_WARNING(__FILE__, "File \"" + nameFile + "\" wasn't created.");
        return false;
    }
}
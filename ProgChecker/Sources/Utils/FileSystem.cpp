#include "FileSystem.h"

namespace Utils
{

    /**
      * The function for reading all the text from file.
      * @param pathFile full path to the file.
      * @return all the text from file.
      */
    std::string read_file(const std::string& pathFile)
    {
        std::wstring another(pathFile.begin(), pathFile.end());
        std::ifstream in(another);
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
     * The function for creation source file of program. File will be created in the:
     * "USER_DIRECTORY/ProgChecker" for POSIX and "USER_DIRECTORY\ProgChecker" for WIN32.
     * @param nameFile only the name of the file, without path.
     * @param text text of source file.
     * @return the file was created or wasn't created.
     */
    bool create_source_file(const std::string& nameFile, const std::string& text)
    {
        #ifdef _WIN32
            std::string pathFile = USER_DIRECTORY + "\\ProgChecker\\" + nameFile;
        #else
            std::string pathFile = USER_DIRECTORY + "ProgChecker/" + nameFile;
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

    /**
     * The function removes an unlimited number of files(source and executable files). Files will
     * be removed from: "USER_DIRECTORY/ProgChecker" for POSIX and "USER_DIRECTORY\ProgChecker" for WIN32.
     * @param nameFile source and executable files for deleting.
     * @param ... source and executable files for deleting.
     */
    void remove_source_and_exe_files(const std::string& nameFile, ...)
    {

    }

}
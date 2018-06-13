#include "FileSystem.h"

namespace Utils
{

    /**
     * The function for creation source file of program. File will be
     * created in the USER_DIRECTORY.
     * @param nameFile only the name of the file, without path.
     * @param text text of source file.
     * @return the file was created or wasn't created.
     */
    bool create_source_file(const std::string& nameFile, const std::string& text)
    {
        std::string pathFile = USER_DIRECTORY + "/" + nameFile;
        std::ofstream out(pathFile);
        if (out.is_open())
        {
            out << text;
            out.close();
            return true;
        }
        else
        {
            LOG_WARNING(__FILE__, "File \"" + pathFile + "\" wasn't created.");
            return false;
        }
    }

    /**
     * The function removes source and executable files. Files will
     * be removed from USER_DIRECTORY.
     * @param nameFile source file for deleting.
     * @param exeFile executable file for deleting.
     */
    void remove_source_and_exe_files(const std::string& sourceFile, const std::string& exeFile)
    {
        std::string pathSourceFile = USER_DIRECTORY + "/"  + sourceFile;

        #ifdef _WIN32
            std::string pathExeFile = USER_DIRECTORY + "/" + exeFile + ".exe";
        #else
            std::string pathExeFile = USER_DIRECTORY + "/" + exeFile;
        #endif

        if (std::remove(pathSourceFile.c_str()))
        {
            LOG_WARNING(__FILE__, "Source file \"" + pathSourceFile + "\" wasn't deleted.");
        }

        if(!exeFile.empty())
        {
            if (std::remove(pathExeFile.c_str()))
            {
                LOG_WARNING(__FILE__, "Executable file \"" + pathExeFile + "\" wasn't deleted.");
            }
        }
    }

}
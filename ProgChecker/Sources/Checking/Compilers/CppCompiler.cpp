#include "CppCompiler.h"

namespace Compilers
{

    /**
     *
     * @return
     */
    bool CppCompiler::compileProgram()
    {
        if(!create_file(_nameProgram + FILE_EXTENSION, _textProgram))
        {
            throw Exceptions::IOException("Source file \"" + _nameProgram + FILE_EXTENSION + "\" wasn't created");
        }
        return runCommand(compileCommand());
    }

    /**
     *
     * @param testData
     * @return
     */
    bool CppCompiler::runProgram(std::vector<std::shared_ptr<TestData>>& testData)
    {
        for (const auto &data : testData)
        {
            if(data->getOutputData() != runCommand(runningCommand(), data->getInputData()))
            {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return
     */
    std::string CppCompiler::compileCommand()
    {
        return COMPILER_NAME + _nameProgram + FILE_EXTENSION + " -o " + _nameProgram; // g++ NAME_PROGRAM.cpp -o NAME_PROGRAM
    }

    /**
     *
     * @return
     */
    std::string CppCompiler::runningCommand()
    {
        #ifdef _WIN32
            return nameProgram + ".exe"; // NAME_PROGRAM.exe
        #else
            return _nameProgram; // NAME_PROGRAM
        #endif
    }

}
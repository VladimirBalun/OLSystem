#include "CppC.h"

namespace SystemChecking::Compilers
{

    int CppC::checkTask(const IProgram::UPtrTask &task)
    {
        if(!compileProgram(task->getTextProgram()))
        {
            return COMPILATION_ERROR;
        }
        if(runProgram(task->getTestDataForTask()))
        {
            return SUCCESSFUL_CHECKING;
        }
        else
        {
            return RUN_TIME_ERROR;
        }
    }

    bool CppC::compileProgram(const std::string& textProgram)
    {
        if(!Utils::create_source_file(__sourceFile, textProgram))
        {
            std::cerr << "Source file for program: \"" + textProgram + "\" wasn't created." << std::endl;
            LOG_WARNING(__FILE__, "Source file for program: \"" + textProgram + "\" wasn't created.");
            return false;
        }
        return Utils::Terminal::runCommand(compileCommand());
    }

    bool CppC::runProgram(std::vector<SPtrTestData>&& testDataForProgram)
    {
        for (const auto &data : testDataForProgram)
        {
            std::string outputProgram = Utils::Terminal::runCommand(runningCommand(), data->getInputData());
            if(data->getOutputData() != outputProgram)
            {
                return false;
            }
        }
        return true;
    }

    std::string CppC::compileCommand()
    {
        return _compilerName + " " + __sourceFile + " -o " + __nameProgram; // g++ cppProgram.cpp -o cppProgram
    }

    std::string CppC::runningCommand()
    {
        #ifdef _WIN32
            return __nameProgram + ".exe"; // cppProgram.exe
        #else
            return __nameProgram; // cppProgram
        #endif
    }

}

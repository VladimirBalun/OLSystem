#include "CppC.h"

namespace SystemChecking::Compilers
{

    /**
     * The method checks task, through compilation and then run
     * the program with the test data.
     * @param task task for checking.
     * @return result checking of task.
     * @see ICompiler
     */
    EResultChecking CppC::checkTask(const IProgram::SPtrTask &task)
    {
        if (!compileProgram(task->getTextProgram()))
        {
            return COMPILATION_ERROR;
        }

        if (runProgram(task->getTestDataForTask()))
        {
            return SUCCESSFUL_CHECKING;
        }
        else
        {
            return RUN_TIME_ERROR;
        }
    }

    /**
     * The method creates source file for program, if source wasn't created, then
     * returns "false". After creating source file, the program is compiled, if
     * compilation is failed, then source file is deleted and after returns "false".
     * But if compilation is successful, then returns "true";
     * @param textProgram source code of program from task.
     * @return failed or successful compilation.
     */
    bool CppC::compileProgram(const std::string& textProgram)
    {
        if (!Utils::create_source_file(__sourceFile, textProgram))
        {
            std::cerr << "Source file for program: \"" + textProgram + "\" wasn't created." << std::endl;
            return false;
        }

        bool isSuccessfulCompilation = Utils::Terminal::runCommand(compileCommand());
        if (isSuccessfulCompilation)
        {
            return true;
        }
        else
        {
            Utils::remove_source_and_exe_files(__sourceFile);
            return false;
        }
    }

    /**
     * The method runs program with test data for it. If output program isn't
     * equal test knowingly correctness output data for program, then returns "false",
     * else returns "true", but before returning - source and executable files are deleted.
     * @param testDataForProgram test data for program from task.
     * @return failed or successful program testing.
     */
    bool CppC::runProgram(std::vector<SPtrTestData>&& testDataForProgram)
    {
        if (testDataForProgram.empty())
        {
            return false;
        }

        bool isSuccessfulRunning = true;
        for (const auto &data : testDataForProgram)
        {
            std::string outputProgram = Utils::Terminal::runCommand(runningCommand(), data->getInputData());
            LOG_DEBUG(__FILE__, "Expected output: \"" + data->getOutputData() + "\" - Program output: \"" + outputProgram + "\".");
            if(data->getOutputData() != outputProgram)
            {
                isSuccessfulRunning = false;
                break;
            }
        }
        Utils::remove_source_and_exe_files(__sourceFile, __nameProgram);
        return isSuccessfulRunning;
    }

    /**
     * The inline method returns command for compiling C or C++ program.
     * @return command for compiling C or C++ program.
     */
    std::string CppC::compileCommand()
    {
        return _compilerName + " " + __sourceFile + " -o " + __nameProgram;
    }

    /**
     * The inline method returns command for running C or C++ program.
     * @return command for running C or C++ program.
     */
    std::string CppC::runningCommand()
    {
        #ifdef _WIN32
            return Utils::USER_DIRECTORY + "/" + __nameProgram + ".exe";
        #else
            return Utils::USER_DIRECTORY + "/" + __nameProgram;
        #endif
    }

}
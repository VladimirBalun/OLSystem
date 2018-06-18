#include "Python.h"

namespace SystemChecking::Interpreters
{

    /**
     * The method checks task, through running program
     * with test data for its.
     * @param task task for checking.
     * @return result checking of task.
     */
    EResultChecking Python::checkTask(const SPtrTask& task)
    {
        return runProgram(task->getTextProgram(), task->getTestDataForTask());
    }

    /**
     * The method before running creates source file for program and checks
     * test data for program. If test data fro program is absent or source file
     * wasn't created, then returns "UNKNOWN_ERROR".
     * @param textProgram source code of program from task.
     * @param testDataForProgram test data for program from task.
     * @return result checking of task.
     */
    EResultChecking Python::runProgram(const std::string& textProgram, std::vector<SPtrTestData>&& testDataForProgram)
    {
        if (!Utils::create_source_file(__sourceFile, textProgram))
        {
            std::cerr << "Source file for program: \"" + textProgram + "\" wasn't created." << std::endl;
            LOG_WARNING(__FILE__, "Source file for program: \"" + textProgram + "\" wasn't created.");
            return UNKNOWN_ERROR;
        }

        if (testDataForProgram.empty())
        {
            Utils::remove_source_and_exe_files(__sourceFile);
            std::cerr << "Program: \"" + textProgram + "\" doesn't have test data. Checking is impossible." << std::endl;
            LOG_WARNING(__FILE__, "Program: \"" + textProgram + "\" doesn't have test data. Checking is impossible.");
            return UNKNOWN_ERROR;
        }

        return runProgramWithTestData(testDataForProgram);
    }

    /**
     * The method runs program with test data for its. If output program isn't
     * equal test knowingly correctness output data for program, then returns "false",
     * else returns "true", but before returning - source file is deleted.
     * @param testDataForProgram test data for program from task.
     * @return result checking of task.
     */
    EResultChecking Python::runProgramWithTestData(std::vector<SPtrTestData>& testDataForProgram)
    {
        EResultChecking resultChecking = SUCCESSFUL_CHECKING;
        for (const auto &data : testDataForProgram)
        {
            std::string outputProgram = Utils::Terminal::runCommand(__runningCommand, data->getInputData());
            LOG_DEBUG(__FILE__, "Expected output: \"" + data->getOutputData() + "\" - Program output: \"" + outputProgram + "\".");
            if (data->getOutputData() != outputProgram)
            {
                resultChecking = RUN_TIME_ERROR;
                break;
            }
        }
        Utils::remove_source_and_exe_files(__sourceFile);
        return resultChecking;
    }

}
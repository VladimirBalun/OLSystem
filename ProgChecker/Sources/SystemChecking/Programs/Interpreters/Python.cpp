#include "Python.h"

namespace SystemChecking::Interpreters
{

    EResultChecking Python::checkTask(const UPtrTask& task)
    {
        return runProgram(task->getTextProgram(), task->getTestDataForTask());
    }

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
            std::cerr << "Program: \"" + textProgram + "\" doesn't have test data. Checking is impossible." << std::endl;
            LOG_WARNING(__FILE__, "Program: \"" + textProgram + "\" doesn't have test data. Checking is impossible.");
            return UNKNOWN_ERROR;
        }
        return runProgramWithTestData(testDataForProgram);
    }

    EResultChecking Python::runProgramWithTestData(std::vector<SPtrTestData>& testDataForProgram)
    {
        for (const auto &testData : testDataForProgram)
        {
            std::string outputProgram = Utils::Terminal::runCommand(__runningCommand, testData->getInputData());
            LOG_DEBUG(__FILE__, "Expected output: \"" + testData->getOutputData() + "\" - Program output: \"" + outputProgram + "\".");
            if (testData->getOutputData() != outputProgram)
            {
                return RUN_TIME_ERROR;
            }
        }
        return SUCCESSFUL_CHECKING;
    }

}
#include "Java.h"

namespace SystemChecking::Compilers
{

    EResultChecking Java::checkTask(const IProgram::UPtrTask& task)
    {
        return SUCCESSFUL_CHECKING;
    }

    bool Java::compileProgram(const std::string& textProgram)
    {
        return false;
    }

    bool Java::runProgram(std::vector<ICompiler::SPtrTestData>&& testData)
    {
        return false;
    }

}
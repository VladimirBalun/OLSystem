#ifndef _I_INTERPRETER_H_
#define _I_INTERPRETER_H_

#include <SystemChecking/Programs/IProgram.h>

namespace SystemChecking::Interpreters
{

    struct IInterpreter : public IProgram
    {
        typedef std::shared_ptr<Objects::TestData> SPtrTestData;
        EResultChecking checkTask(const UPtrTask& task) override = 0;
        virtual EResultChecking runProgram(const std::string& textProgram, std::vector<SPtrTestData>&& testDataForProgram) = 0;
    };

}

#endif

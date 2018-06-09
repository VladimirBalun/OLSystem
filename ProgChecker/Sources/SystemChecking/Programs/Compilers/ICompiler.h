#ifndef _ICOMPILABLE_H_
#define _ICOMPILABLE_H_

#include <SystemChecking/Programs/IProgram.h>

namespace SystemChecking
{
    namespace Compilers
    {

        struct ICompiler : public IProgram
        {
            typedef std::shared_ptr<Objects::TestData> SPtrTestData;
            int checkTask(const UPtrTask& task) override = 0;
            virtual bool compileProgram(const std::string& textProgram) = 0;
            virtual bool runProgram(std::vector<SPtrTestData>&& testData) = 0;
        };

    }
}

#endif

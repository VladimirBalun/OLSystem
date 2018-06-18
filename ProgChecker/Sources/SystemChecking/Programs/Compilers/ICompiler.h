#ifndef _I_COMPILER_H_
#define _I_COMPILER_H_

#include <SystemChecking/Programs/IProgram.h>

namespace SystemChecking
{
    namespace Compilers
    {

        /**
         * The interface - for all the compilers in this project.
         * Each compiler implements this interface for checking tasks.
         * Interface extends one method from adapter(IProgram) and allocates
         * methods for individual compiling and run with testing program from task.
         * @see IProgram
        */
        struct ICompiler : public IProgram
        {
            typedef std::shared_ptr<Objects::TestData> SPtrTestData;

            EResultChecking checkTask(const SPtrTask& task) override = 0;
            virtual bool compileProgram(const std::string& textProgram) = 0;
            virtual bool runProgram(std::vector<SPtrTestData>&& testData) = 0;
            virtual ~ICompiler() = default;
        };

    }
}

#endif
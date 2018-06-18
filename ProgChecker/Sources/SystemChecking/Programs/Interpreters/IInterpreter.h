#ifndef _I_INTERPRETER_H_
#define _I_INTERPRETER_H_

#include <SystemChecking/Programs/IProgram.h>

namespace SystemChecking::Interpreters
{

    /**
     * The interface - for all the interpreters in this project.
     * Each interpreter implements this interface for checking tasks.
     * Interface extends one method from adapter(IProgram) and allocates
     * method for run with testing program from task.
     * @see IProgram
    */
    struct IInterpreter : public IProgram
    {
        typedef std::shared_ptr<Objects::TestData> SPtrTestData;

        EResultChecking checkTask(const SPtrTask& task) override = 0;
        virtual EResultChecking runProgram(const std::string& textProgram, std::vector<SPtrTestData>&& testDataForProgram) = 0;
        virtual ~IInterpreter() = default;
    };

}

#endif
#ifndef _I_PROGRAM_H_
#define _I_PROGRAM_H_

#include <vector>
#include <memory>

#include "DataObjects/Task.h"
#include "Utils/Terminal.h"
#include "SystemChecking/EResultChecking.h"

namespace SystemChecking
{

    /**
     * The interface - adapter for compilers and interpreters.
     * It allocates one common method for checking task, but
     * compilers and interpreters implement it in different ways.
     */
    struct IProgram
    {
        typedef std::unique_ptr<Objects::Task> UPtrTask;
        virtual EResultChecking checkTask(const UPtrTask& task) = 0;
    };

}

#endif

#ifndef _ICHECKING_PROGRAM_H
#define _ICHECKING_PROGRAM_H

#include <vector>
#include <memory>

#include "Objects/Task.h"
#include "Utils/Terminal.h"
#include "SystemChecking/EResultChecking.h"

namespace SystemChecking
{

    struct IProgram
    {
        typedef std::unique_ptr<Objects::Task> UPtrTask;
        virtual int checkTask(const UPtrTask& task) = 0;
    };

}

#endif

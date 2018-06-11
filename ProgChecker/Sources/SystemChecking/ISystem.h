#ifndef _ICHECKING_PROGRAM_H_
#define _ICHECKING_PROGRAM_H_

#include <vector>
#include <memory>

#include "DataObjects/Task.h"
#include "Utils/Terminal.h"

namespace SystemChecking
{

    struct ISystem
    {
        typedef std::unique_ptr<Objects::Task> UPtrTask;
        virtual int checkTask(const UPtrTask& task) = 0;
        virtual ~ISystem() {}
    };

}

#endif
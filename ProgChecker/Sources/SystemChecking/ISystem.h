#ifndef _I_SYSTEM_H_
#define _I_SYSTEM_H_

#include <vector>
#include <memory>

#include "DataObjects/Task.h"
#include "EResultChecking.h"

namespace SystemChecking
{

    /**
     * The interface of checking system package.
     * It contains an external API for working
     * checking system of tasks.
     */
    struct ISystem
    {
        typedef std::shared_ptr<Objects::Task> SPtrTask;
        virtual EResultChecking checkTask(SPtrTask&& task) = 0;
        virtual ~ISystem() = default;
    };

}

#endif
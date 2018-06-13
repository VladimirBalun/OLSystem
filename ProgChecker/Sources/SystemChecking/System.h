#ifndef _SYSTEM_H_
#define _SYSTEM_H_

#include <string>
#include <cstring>
#include <vector>
#include <iostream>
#include <memory>

#include "Exceptions/SystemChecking/SystemCheckingException.h"
#include "SystemChecking/ISystem.h"
#include "SystemChecking/Programs/CreatorPrograms.h"

namespace SystemChecking
{

    /**
     * The class implements interface of ISystem. When creating this class,
     * the selected compiler or interpreter is created for checking the tasks.
     * If language doesn't support by ProgChceker,or compiler and interpreter
     * absent in OS, then the class won't be created.
     * @See ISystem
     */
    class System : public ISystem
    {
    public:
        System(const std::string& nameLanguage, const std::string& nameProgram);
        EResultChecking checkTask(const UPtrTask& task) override;
    private:
        std::unique_ptr<SystemChecking::IProgram> _checkingProgram;
    };

}

#endif

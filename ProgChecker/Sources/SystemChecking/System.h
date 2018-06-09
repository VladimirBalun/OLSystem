#ifndef _CHECKING_PROGRAM_H_
#define _CHECKING_PROGRAM_H_

#include <string>
#include <cstring>
#include <vector>
#include <iostream>
#include <memory>

#include "Exceptions/SystemCheckingException.h"
#include "SystemChecking/ISystem.h"
#include "SystemChecking/Programs/CreatorPrograms.h"

namespace SystemChecking
{

    class System : public ISystem
    {
    public:
        System(const std::string& nameLanguage, const std::string& nameProgram);
        int checkTask(const UPtrTask& task) override;
    private:
        std::unique_ptr<SystemChecking::IProgram> _checkingProgram;
    };

}

#endif

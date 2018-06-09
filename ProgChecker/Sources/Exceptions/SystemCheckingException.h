#ifndef _SYSTEM_CHECKING_EXCEPTION_H_
#define _SYSTEM_CHECKING_EXCEPTION_H_

#include "IException.h"

namespace Exceptions
{

    class SystemCheckingException : public IException
    {
        std::string _message;
    public:
        SystemCheckingException(const std::string& message) : _message(message) {}
        inline std::string what() override { return "System checking exception exception: " + _message; }
    };

}

#endif

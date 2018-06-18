#ifndef _SYSTEM_CHECKING_EXCEPTION_H_
#define _SYSTEM_CHECKING_EXCEPTION_H_

#include "Exceptions/IException.h"

namespace Exceptions
{

    /**
     * Exception is used when working with the system
     * checking of the tasks.
     */
    class SystemCheckingException : public IException
    {
    protected:
        std::string _message;
    public:
        SystemCheckingException(const std::string& message) : _message(message) {}
        inline std::string what() override { return "System checking exception: " + _message; }
    };

}

#endif
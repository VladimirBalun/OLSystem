#ifndef _NETWORK_EXCEPTION_H_
#define _NETWORK_EXCEPTION_H_

#include "IException.h"

namespace Exceptions
{

    class NetworkException : public IException
    {
        std::string _message;
    public:
        NetworkException(const std::string& message) : _message(message) {}
        inline std::string what() override { return "Network exception: " + _message; }
    };

}

#endif

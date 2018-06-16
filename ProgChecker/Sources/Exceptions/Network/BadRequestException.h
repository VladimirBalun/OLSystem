#ifndef _BAD_REQUEST_EXCEPTION_H
#define _BAD_REQUEST_EXCEPTION_H

#include "NetworkException.h"

namespace Exceptions
{

    class BadRequestException : public NetworkException
    {
    public:
        BadRequestException(const std::string& message) : NetworkException(message) {}
        inline std::string what() override { return _message; }
    };

}

#endif
#ifndef _NETWORK_EXCEPTION_H_
#define _NETWORK_EXCEPTION_H_

#include "Exceptions/IException.h"

namespace Exceptions
{

    /**
     * Exception is used when working with the network.
     */
    class NetworkException : public IException
    {
    protected:
        std::string _message;
    public:
        NetworkException(const std::string& message) : _message(message) {}
        inline std::string what() override { return "Network exception: " + _message; }
    };

}

#endif

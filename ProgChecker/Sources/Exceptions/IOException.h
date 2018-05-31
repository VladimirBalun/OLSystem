#ifndef _IOEXCEPTION_H
#define _IOEXCEPTION_H

#include "IException.h"

namespace Exceptions
{

    class IOException : public IException
    {
        std::string _message;
    public:
        IOException(const std::string& message) : _message(message) {}
        inline std::string what() override { return "IO exception: " + _message; }
    };

}

#endif // _IOEXCEPTION_H

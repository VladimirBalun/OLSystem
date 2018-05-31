#ifndef _IEXCEPTION_H
#define _IEXCEPTION_H

#include <string>

namespace Exceptions
{

    struct IException
    {
        virtual std::string what() = 0;
        virtual ~IException() {}
    };

}

#endif // _IEXCEPTION_H

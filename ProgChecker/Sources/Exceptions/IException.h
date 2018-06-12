#ifndef _IEXCEPTION_H_
#define _IEXCEPTION_H_

#include <string>

namespace Exceptions
{

    /**
     * The interface of all the exceptions in this
     * project. All the exceptions in this project
     * implement it.
     */
    struct IException
    {
        virtual std::string what() = 0;
        virtual ~IException() = default;
    };

}

#endif

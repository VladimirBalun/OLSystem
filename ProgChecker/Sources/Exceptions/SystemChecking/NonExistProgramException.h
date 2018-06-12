#ifndef _NONEXIST_PROGRAM_EXCEPTION_H_
#define _NONEXIST_PROGRAM_EXCEPTION_H_

#include "SystemCheckingException.h"

namespace Exceptions
{

    class NonExistProgramException : public SystemCheckingException
    {
    public:
        NonExistProgramException(const std::string& message) : SystemCheckingException(message) {}
        inline std::string what() override { return _message; }
    };

}

#endif

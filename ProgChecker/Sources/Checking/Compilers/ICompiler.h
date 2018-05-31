#ifndef _ICOMPILER_H_
#define _ICOMPILER_H_

#include <vector>
#include <memory>

#include "Checking/Terminal.h"
#include "Exceptions/IOException.h"
#include "Data/Entity/TestData.h"

namespace Compilers
{

    struct ICompiler : protected Terminal
    {
        virtual bool compileProgram() = 0;
        virtual bool runProgram(std::vector<std::shared_ptr<TestData>>& testData) = 0;
    };

}

#endif // _ICOMPILER_H_

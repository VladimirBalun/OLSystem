#ifndef _CPP_COMPILER_H_
#define _CPP_COMPILER_H_

#include <string>
#include <utility>
#include "ICompiler.h"
#include "Data/Accesses/FileSystem.h"
#include "Utils/Logger.h"

namespace Compilers
{

    class CppCompiler : private ICompiler
    {
    public:
        explicit CppCompiler(std::string nameProgram, std::string textProgram) :
                _nameProgram(std::move(nameProgram)), _textProgram(std::move(textProgram))  {}
        bool compileProgram() override;
        bool runProgram(std::vector<std::shared_ptr<TestData>>& testData) override;
    private:
        std::string _nameProgram;
        std::string _textProgram;
        static inline const char* COMPILER_NAME = "g++ ";
        static inline const char* FILE_EXTENSION = ".cpp";
    private:
        __always_inline std::string compileCommand();
        __always_inline std::string runningCommand();
    };

}

#endif // _CPP_COMPILER_H

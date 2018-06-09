#ifndef _CPP_COMPILER_H_
#define _CPP_COMPILER_H_

#include <string>
#include <utility>
#include "ICompiler.h"
#include "Utils/FileSystem.h"
#include "Utils/Logger.h"

namespace SystemChecking::Compilers
{

    class CppC : public ICompiler
    {
    public:
        explicit CppC(const std::string& compilerName) : _compilerName(compilerName) {}
        int checkTask(const UPtrTask& task) override;
    private:
        bool compileProgram(const std::string& textProgram) override;
        bool runProgram(std::vector<SPtrTestData>&& testData) override;
        inline std::string compileCommand();
        inline std::string runningCommand();
    private:
        std::string _compilerName;
        const std::string __nameProgram = "cppProgram";
        const std::string __fileExtension = ".hpp";
        const std::string __sourceFile = __nameProgram + __fileExtension;
    };

}

#endif

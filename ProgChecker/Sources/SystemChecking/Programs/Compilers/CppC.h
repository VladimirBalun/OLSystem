#ifndef _CPP_C_H_
#define _CPP_C_H_

#include "ICompiler.h"
#include "Utils/FileSystem.h"
#include "Utils/Logger.h"

namespace SystemChecking::Compilers
{

    /**
     * The class represents compiler of C or C++ languages and
     * implements interface of ICompiler. It used for checking
     * programs in C and C++ languages.
     * @see ICompiler
     */
    class CppC : public ICompiler
    {
        std::string _compilerName;
        const std::string __nameProgram = "cppProgram";
        const std::string __fileExtension = ".hpp";
        const std::string __sourceFile = __nameProgram + __fileExtension;
    public:
        explicit CppC(const std::string& compilerName) : _compilerName(compilerName) {}
        EResultChecking checkTask(const SPtrTask& task) override;
    private:
        bool compileProgram(const std::string& textProgram) override;
        bool runProgram(std::vector<SPtrTestData>&& testData) override;
        inline std::string compileCommand();
        inline std::string runningCommand();
    };

}

#endif
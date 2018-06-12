#ifndef _JAVA_H
#define _JAVA_H

#include "ICompiler.h"

namespace SystemChecking::Compilers
{

    class Java : public ICompiler
    {
    public:
        EResultChecking checkTask(const UPtrTask& task) override;
    private:
        bool compileProgram(const std::string& textProgram) override;
        bool runProgram(std::vector<SPtrTestData>&& testData) override;
    private:
        std::string _compilerName;
        const std::string _nameProgram;
        const std::string __platformName = "java";
        const std::string __fileExtension = ".java";
        const std::string __sourceFile = _nameProgram + __fileExtension;
    };

}

#endif

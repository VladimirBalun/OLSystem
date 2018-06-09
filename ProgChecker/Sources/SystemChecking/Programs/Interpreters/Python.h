#ifndef _PYTHON_INTERPRETER_H
#define _PYTHON_INTERPRETER_H

#include "IInterpreter.h"
#include "Utils/Logger.h"
#include "Utils/FileSystem.h"

namespace SystemChecking::Interpreters
{

    class Python : public IInterpreter
    {
    public:
        explicit Python(const std::string& interpreterName) : _interpreterName(interpreterName) {}
        int checkTask(const UPtrTask& task) override;
    private:
        int runProgram(const std::string& textProgram, std::vector<SPtrTestData>&& testDataForProgram) override;
        int runProgramWithTestData(std::vector<SPtrTestData>& testDataForProgram);
    private:
        std::string _interpreterName;
        const std::string __sourceFile = "pythonProgram.py";
        const std::string __runningCommand = _interpreterName + " " + __sourceFile;
    };

}

#endif
#ifndef _PYTHON_INTERPRETER_H_
#define _PYTHON_INTERPRETER_H_

#include "IInterpreter.h"
#include "Utils/Logger.h"
#include "Utils/FileSystem.h"

namespace SystemChecking::Interpreters
{

    /**
     * The class represents interpreter of Python language and
     * implements interface of IInterpreter. It used for checking
     * programs in Python language.
     * @see IInterpreter
     */
    class Python : public IInterpreter
    {
        std::string _interpreterName;
        const std::string __sourceFile = "pythonProgram.py";
        const std::string __runningCommand = _interpreterName + " " + __sourceFile;
    public:
        explicit Python(const std::string& interpreterName) : _interpreterName(interpreterName) {}
        EResultChecking checkTask(const UPtrTask& task) override;
    private:
        EResultChecking runProgram(const std::string& textProgram, std::vector<SPtrTestData>&& testDataForProgram) override;
        EResultChecking runProgramWithTestData(std::vector<SPtrTestData>& testDataForProgram);
    };

}

#endif
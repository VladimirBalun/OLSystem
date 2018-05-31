#include "Program.h"

/**
 *
 * @param lang
 */
void Program::setLanguageForPrograms(const char* lang)
{
    CURR_LANGUAGE = lang;
}

/**
 *
 * @param testData
 * @return
 */
int Program::checkProgram(std::vector<std::shared_ptr<TestData>>& testData)
{
    if((strcmp(CURR_LANGUAGE, "C")) == 0)
    {
        return checkCProgram(testData);
    }
    if((strcmp(CURR_LANGUAGE, "Cpp")) == 0L)
    {
        return checkCppProgram(testData);
    }
    if((strcmp(CURR_LANGUAGE, "Java")) == 0)
    {
        return checkJavaProgram(testData);
    }
    if((strcmp(CURR_LANGUAGE, "Python")) == 0)
    {
        return checkPythonProgram(testData);
    }
}

/**
 *
 * @param testData
 * @return
 */
int Program::checkCProgram(std::vector<std::shared_ptr<TestData>>& testData)
{
    Compilers::CCompiler compiler;
    return 0;
}

/**
 *
 * @param testData
 * @return
 */
int Program::checkCppProgram(std::vector<std::shared_ptr<TestData>>& testData)
{
    try
    {
        Compilers::CppCompiler compiler(_nameProgram, _textProgram);
        if(!compiler.compileProgram())
        {
            LOG_INFO(__FILE__, "Program \"" + _nameProgram + "\" is incorrect: compilation error.");
            return COMPILATION_ERROR;
        }
        if(!compiler.runProgram(testData))
        {
            LOG_INFO(__FILE__, "Program \"" + _nameProgram + "\" is incorrect: run-time error.");
            return RUN_TIME_ERROR;
        }
        else
        {
            LOG_INFO(__FILE__, "Program \"" + _nameProgram + "\" is correct.");
            return SUCCESSFUL_CHECKING;
        }
    }
    catch (Exceptions::IOException& e)
    {
        LOG_ERROR(__FILE__, e.what());
        return SYSTEM_ERROR;
    }
    catch (...)
    {
        LOG_ERROR(__FILE__, "Unknown error: program is incorrect.");
        return UNKNOWN_ERROR;
    }
}

/**
 *
 * @param testData
 * @return
 */
int Program::checkJavaProgram(std::vector<std::shared_ptr<TestData>>& testData)
{
    std::cout << "Java" << std::endl;
    return 0;
}

/**
 *
 * @param testData
 * @return
 */
int Program::checkPythonProgram(std::vector<std::shared_ptr<TestData>>& testData)
{
    std::cout << "Python" << std::endl;
    return 0;
}




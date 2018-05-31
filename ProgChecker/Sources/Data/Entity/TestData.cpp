#include "TestData.h"

void TestData::setInputData(const std::string &inputData)
{
    _inputData = inputData;
}

std::string TestData::getInputData() const
{
    return _inputData;
}

void TestData::setOutputData(const std::string &outputData)
{
    _outputData = outputData;
}

std::string TestData::getOutputData() const
{
    return _outputData;
}

std::string TestData::toString() const
{
    return "OutputData: [" + _outputData + "] InputData: [" + _inputData + "]\n";
}
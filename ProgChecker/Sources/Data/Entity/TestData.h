#ifndef _TESTDATA_H
#define _TESTDATA_H

#include <string>
#include <vector>

#include "TestData.h"

class TestData
{
public:
    TestData(std::string inputData, std::string outputData) :
            _inputData(std::move(inputData)), _outputData(std::move(outputData)) {}

    void setInputData(const std::string& inputData);
    std::string getInputData() const;
    void setOutputData(const std::string& outputData);
    std::string getOutputData() const;

    std::string toString() const;
private:
    std::string _inputData;
    std::string _outputData;
};


#endif //_TESTDATA_H

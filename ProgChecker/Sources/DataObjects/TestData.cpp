#include "TestData.h"

namespace Objects
{

    /**
     * The method sets test input data for program.
     * @param inputData test input data for program.
     */
    void TestData::setInputData(const std::string &inputData)
    {
        _inputData = inputData;
    }

    /**
     * The method returns test input data for program.
     * @param inputData test input data for program.
     */
    std::string TestData::getInputData() const
    {
        return _inputData;
    }

    /**
     * The method sets test knowingly correctness output data for program.
     * @param outputData test knowingly correctness output data for program.
     */
    void TestData::setOutputData(const std::string &outputData)
    {
        _outputData = outputData;
    }

    /**
     * The method returns test knowingly correctness output data for program.
     * @param outputData test knowingly correctness output data for program.
     */
    std::string TestData::getOutputData() const
    {
        return _outputData;
    }

    /**
     * The method returns text representation of an object.
     * @return text representation of an object.
     */
    std::string TestData::toString() const
    {
        return "TestData[InputData: \"" + _inputData + "\" - OutputData: \"" + _outputData + "\"]\n";
    }

}
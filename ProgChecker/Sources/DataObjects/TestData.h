#ifndef _TEST_DATA_H_
#define _TEST_DATA_H_

#include <string>
#include <vector>

namespace Objects
{

    /**
     * The class represents test data for program. It
     * contains text program(source code) and test data
     * for program.
     * #see TestData
     */
    class TestData
    {
        std::string _inputData;
        std::string _outputData;
    public:
        TestData(const std::string& inputData, const std::string& outputData) : _inputData(inputData), _outputData(outputData) {}
        void setInputData(const std::string& inputData);
        std::string getInputData() const;
        void setOutputData(const std::string& outputData);
        std::string getOutputData() const;
        std::string toString() const;
    };

}

#endif

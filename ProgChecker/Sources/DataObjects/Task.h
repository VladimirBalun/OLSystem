#ifndef _TASK_H_
#define _TASK_H_

#include <string>
#include <vector>

#include "TestData.h"

namespace Objects
{

    /**
     * The class represents task. It
     * contains  correctness output data
     * for the program.
     */
    class Task
    {
        typedef std::shared_ptr<TestData> SPtrTestData;

        std::string _textProgram;
        std::vector<SPtrTestData> _testDataForTask;
    public:
        Task(const std::string& textProgram, std::vector<SPtrTestData>& testDataForTask) : _textProgram(textProgram), _testDataForTask(testDataForTask) {}
        Task(const std::string& textProgram, std::vector<SPtrTestData>&& testDataForTask) : _textProgram(textProgram), _testDataForTask(std::move(testDataForTask)) {}
        std::string getTextProgram() const ;
        void setTextProgram(const std::string& textProgram);
        std::vector<SPtrTestData> getTestDataForTask() const;
        void addTestData(const SPtrTestData& testData);
        void setTestDataForTask(const std::vector<SPtrTestData>& testDataForTask);
        std::string toString() const;
    };

}

#endif
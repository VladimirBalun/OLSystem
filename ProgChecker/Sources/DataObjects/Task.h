#ifndef _TASK_H_
#define _TASK_H_

#include <string>
#include <vector>

#include "TestData.h"

namespace Objects
{

    class Task
    {
    public:
        typedef std::shared_ptr<TestData> SPtrTestData;
        Task(const std::string& textProgram, std::vector<SPtrTestData>& testDataForTask) : _textProgram(textProgram), _testDataForTask(testDataForTask) {}
        std::string getTextProgram() const ;
        void setTextProgram(const std::string& textProgram);
        std::vector<SPtrTestData> getTestDataForTask() const;
        void addTestData(const SPtrTestData& testData);
        void setTestDataForTask(const std::vector<SPtrTestData>& testDataForTask);
        std::string toString() const;
    private:
        std::string _textProgram;
        std::vector<SPtrTestData> _testDataForTask;
    };

}

#endif
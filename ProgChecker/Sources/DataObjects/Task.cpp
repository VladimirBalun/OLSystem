#include "Task.h"

namespace Objects
{

    std::string Task::getTextProgram() const
    {
        return _textProgram;
    }

    void Task::setTextProgram(const std::string& textProgram)
    {
        _textProgram = textProgram;
    }

    std::vector<Task::SPtrTestData> Task::getTestDataForTask() const
    {
        return _testDataForTask;
    }

    void Task::addTestData(const Task::SPtrTestData& testData)
    {
        _testDataForTask.push_back(testData);
    }

    void Task::setTestDataForTask(const std::vector<Task::SPtrTestData>& testDataForTask)
    {
        _testDataForTask = testDataForTask;
    }

    std::string Task::toString() const
    {
        return "TextProgram: [" + _textProgram + "]\n";
    }

}




#include "Task.h"

namespace Objects
{

    /**
     * The method returns text program(source code).
     * @return text program(source code).
     */
    std::string Task::getTextProgram() const
    {
        return _textProgram;
    }

    /**
     * The method sets text program(source code).
     * @param textProgram text program(source code).
     */
    void Task::setTextProgram(const std::string& textProgram)
    {
        _textProgram = textProgram;
    }

    /**
     * The method sets test data of current task.
     * @return vector of smart pointers to test data.
     * @see TestData
     */
    std::vector<Task::SPtrTestData> Task::getTestDataForTask() const
    {
        return _testDataForTask;
    }

    /**
     * The method adds test data for current task.
     * @param testData smart pointer to test data.
     * @see TestData
     */
    void Task::addTestData(const Task::SPtrTestData& testData)
    {
        _testDataForTask.push_back(testData);
    }

    /**
     * The method sets test data for current task.
     * @param testDataForTask vector of smart pointers to test data.
     * @see TestData
     */
    void Task::setTestDataForTask(const std::vector<Task::SPtrTestData>& testDataForTask)
    {
        _testDataForTask = testDataForTask;
    }

    /**
     * The method returns text representation of an object.
     * @return text representation of an object.
     */
    std::string Task::toString() const
    {
        std::string stringTask = "Task[TextProgram: \"" + _textProgram + "\"\n";
        for (const auto& data : _testDataForTask)
        {
            stringTask.append(data->toString());
        }
        return stringTask;
    }

}
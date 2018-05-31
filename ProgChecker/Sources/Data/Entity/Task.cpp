#include "Task.h"

std::string Task::getNameProgram() const
{
    return _nameProgram;
}

void Task::setNameProgram(const std::string& nameProgram)
{
    _nameProgram = nameProgram;
}

std::string Task::getTextProgram() const
{
    return _textProgram;
}

void Task::setTextProgram(const std::string& textProgram)
{
    _textProgram = textProgram;
}

std::vector<TestData> Task::getTestDataForTask() const
{
    return _testDataForTask;
}

void Task::addTestData(const TestData &testData)
{
    _testDataForTask.push_back(testData);
}

void Task::setTestDataForTask(const std::vector<TestData>& testDataForTask)
{
    _testDataForTask = testDataForTask;
}

std::string Task::toString() const
{

    return "NameProgram: [" + _nameProgram + "] "
           "TextProgram: [" + _textProgram + "]\n";
}


#ifndef _TASK_H
#define _TASK_H

#include <string>
#include <vector>

#include "TestData.h"

class Task
{
public:
    Task(std::string nameProgram, std::string textProgram, std::vector<TestData>& testDataForTask) :
            _nameProgram(std::move(nameProgram)), _textProgram(std::move(textProgram)), _testDataForTask(testDataForTask) {}

    std::string getNameProgram() const;
    void setNameProgram(const std::string& nameProgram);
    std::string getTextProgram() const ;
    void setTextProgram(const std::string& textProgram);
    std::vector<TestData> getTestDataForTask() const;
    void addTestData(const TestData& testData);
    void setTestDataForTask(const std::vector<TestData>& testDataForTask);

    std::string toString() const;
private:
    std::string _nameProgram;
    std::string _textProgram;
    std::vector<TestData> _testDataForTask;
};

#endif // _TASK_H
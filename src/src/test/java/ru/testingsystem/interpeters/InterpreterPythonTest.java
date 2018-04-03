package ru.testingsystem.interpeters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.testingsystem.checkingTask.ResultCheckingProgram;
import ru.testingsystem.checkingTask.interpreters.Interpreter;
import ru.testingsystem.configuration.ProgrammingLanguageConfig;
import ru.testingsystem.data.entity.TestData;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProgrammingLanguageConfig.class)
public class InterpreterPythonTest {

    @Autowired
    @Qualifier("languagePython")
    private Interpreter interpreterPython;

    @Test
    public void testErrorRunningProgram(){
        // Test program calculates count letters in the word,
        // but outputs the incorrect result
        String source = "import sys \n" +
                        "print len(sys.argv[1] + 5)";
        // Test input and output data for program
        List<TestData> testDataForProgram = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            String randomData = String.valueOf((int) (Math.random() * 1000000));
            TestData testData = new TestData(randomData, String.valueOf(randomData.length()), null);
            testDataForProgram.add(testData);
        }
        ResultCheckingProgram result = interpreterPython.checkProgram("Test", source, testDataForProgram);
        Assert.assertEquals(ResultCheckingProgram.ERROR_RUNNING_PROGRAM, result);
    }

    @Test
    public void testSuccessRunningProgram(){
        // Test program calculates count letters in the word
        String source = "import sys \n" +
                        "print len(sys.argv[1])";
        // Test input and output data for program
        List<TestData> testDataForProgram = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            String randomData = String.valueOf((int) (Math.random() * 1000000));
            TestData testData = new TestData(randomData, String.valueOf(randomData.length()), null);
            testDataForProgram.add(testData);
        }
        ResultCheckingProgram result = interpreterPython.checkProgram("Test", source, testDataForProgram);
        Assert.assertEquals(ResultCheckingProgram.SUCCESS, result);
    }

}

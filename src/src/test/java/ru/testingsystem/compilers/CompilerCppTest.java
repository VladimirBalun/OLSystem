package ru.testingsystem.compilers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.olympiad.checking_task.compilers.Compiler;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context.xml")
public class CompilerCppTest {

    @Autowired
    @Qualifier("compilerCpp")
    private Compiler compilerCppLanguage;

    /**
     * Method creates test program, which will count a count chars in
     * the string. After checks compilation of the program.
     */
    @Test
    public void compileProgram(){
        String testTextProgram = "#include <stdio.h>\n" +
                "#include <iostream>\n" +
                "#include <cstring>\n" +
                "int main(int argc, char *argv[])\n" +
                "{\n" +
                "    std::cout << strlen(argv[1]);\n" +
                "    return 0;\n" +
                "}";
        Assert.assertTrue(compilerCppLanguage.compileProgram(testTextProgram));
    }

    /**
     * Method generates test input data for program and checks the
     * program the correct answer of the program on input data for its.
     */
    @Test
    public void runProgramAndCheckResult(){
        // Fill test data for check compiler
        List<TestData> testDataForProgram = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            String randomData = String.valueOf((int) (Math.random() * 1000000));
            TestData testData = new TestData(randomData, String.valueOf(randomData.length()));
            testDataForProgram.add(testData);
        }
        Assert.assertTrue(compilerCppLanguage.runProgram(testDataForProgram));
    }

}


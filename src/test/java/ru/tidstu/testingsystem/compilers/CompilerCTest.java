package ru.tidstu.testingsystem.compilers;

import org.junit.Assert;
import org.junit.Test;
import ru.tidstu.testingsystem.data.entity.TestData;

import java.util.ArrayList;
import java.util.List;

/**
 * Current test checks serviceability of checks tasks with C language
 * compiler. Here checks compilation and correct running of the
 * program.
 */
public class CompilerCTest {

    private Compiler compilerCLanguage = new CompilerC();
    private List<TestData> testDataForProgram = new ArrayList<TestData>();

    /**
     * Method creates test program, which will count a count chars in
     * the string. After checks compilation of the program.
     */
    @Test
    public void compileProgram(){
        String testTextProgram = "#include <stdio.h>\n" +
                                 "#include <string.h>\n" +
                                 "int main(int argc, char *argv[])\n" +
                                 "{\n" +
                                 "    printf(\"%d\", strlen(argv[1]));\n" +
                                 "    return 0;\n" +
                                 "}";
        Assert.assertTrue(compilerCLanguage.compileProgram(testTextProgram));
    }

    /**
     * Method generates test input data for program and checks the
     * program the correct answer of the program on input data for its.
     */
    @Test
    public void runProgramAndCheckResult(){
        // Fill test data for check compiler
        for (int i = 0; i < 5; i++){
            String randomData = String.valueOf((int) (Math.random() * 1000000));
            TestData testData = new TestData(randomData, String.valueOf(randomData.length()));
            testDataForProgram.add(testData);
        }
        Assert.assertTrue(compilerCLanguage.runProgram(testDataForProgram));
    }

}

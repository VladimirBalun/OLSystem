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
import ru.testingsystem.utils.compilers.Compiler;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context.xml")
public class ByteCodeInterpreterJavaTest {

    @Autowired
    @Qualifier("byteCodeInterpreterJava")
    private Compiler byteCodeInterpreterJava;

    @Test
    public void runFailCompilation(){
        String testTextProgram = "class test{\n" +
                                 "   illegal syntax\n" +
                                 "   public static void main(String args[]){\n" +
                                 "       System.out.println(args[0].length());\n" +
                                 "   }\n" +
                                 "}";
        Assert.assertFalse(byteCodeInterpreterJava.compileProgram(testTextProgram));
    }

    @Test
    public void runSuccessfulCompilation(){
        String testTextProgram = "class test{\n" +
                                 "   public static void main(String args[]){\n" +
                                 "       System.out.println(args[0].length());\n" +
                                 "   }\n" +
                                 "}";
        Assert.assertTrue(byteCodeInterpreterJava.compileProgram(testTextProgram));
    }

    @Test
    public void runProgramAndCheckResult(){
        // Fill test data for check compiler
        List<TestData> testDataForProgram = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            String randomData = String.valueOf((int) (Math.random() * 1000000));
            TestData testData = new TestData(randomData, String.valueOf(randomData.length()));
            testDataForProgram.add(testData);
        }
        Assert.assertTrue(byteCodeInterpreterJava.runProgram(testDataForProgram));
    }

}

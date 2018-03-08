package ru.testingsystem.terminals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.testingsystem.olympiad.checking_task.terminals.Terminal;

import java.io.BufferedReader;
import java.io.IOException;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context.xml")
public class TerminalTest {

    @Autowired
    private Terminal terminal;

    @Test
    public void runCommand(){
        String command = "echo Hello world";
        String resultCommand = "Hello world";
        BufferedReader bufferedReader = terminal.runCommand(command);
        try {
            Assert.assertEquals(bufferedReader.readLine(), resultCommand);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}

package ru.testingsystem;

import org.junit.Assert;
import org.junit.Test;
import ru.testingsystem.checkingTask.Terminal;

public class TerminalTest {

    private Terminal terminal = new Terminal();

    @Test
    public void createAndDeleteSourceFile(){
        String nameFile = "test.cpp";
        String text = "Hello world";
        if(!terminal.createSourceFile(nameFile, text)){
            Assert.fail();
        }
        if(!terminal.removeSourceAndExeFiles(nameFile)){
            Assert.fail();
        }
        Assert.assertTrue(true);
    }


}

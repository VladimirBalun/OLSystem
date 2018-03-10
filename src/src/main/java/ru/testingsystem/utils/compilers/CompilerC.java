package ru.testingsystem.utils.compilers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.entity.TestData;
import ru.testingsystem.utils.terminals.Terminal;

import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompilerC implements Compiler {

    @Autowired
    private Terminal terminal;

    private String nameFile = "test";
    private final String FILE_EXTENSION = ".c";
    private final String COMPILER_NAME = "gcc";

    @Override
    public boolean compileProgram(String textProgram) {
        String commandCompilation = COMPILER_NAME + " " + nameFile + FILE_EXTENSION + " -o " + nameFile;
        return terminal.compile(commandCompilation, nameFile, FILE_EXTENSION, textProgram);
    }

    @Override
    public boolean runProgram(List<TestData> testDataForProgram) {
        return  terminal.runProgram(nameFile, FILE_EXTENSION, testDataForProgram);
    }

}

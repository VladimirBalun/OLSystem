package ru.testingsystem.utils.compilers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.testingsystem.data.domain.TestDataQuestion;
import ru.testingsystem.utils.terminals.Terminal;

import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ByteCodeInterpreterJava implements Compiler {

    @Autowired
    private Terminal terminal;

    private String nameFile = "test";
    private final String FILE_EXTENSION = ".java";
    private final String COMPILER_NAME = "javac";
    private final String NAME_VM = "java";

    @Override
    public boolean compileProgram(String textProgram) {
        String commandCompilation = COMPILER_NAME + " " + nameFile + FILE_EXTENSION;
        return terminal.compile(commandCompilation, nameFile, FILE_EXTENSION, textProgram);
    }

    @Override
    public boolean runProgram(List<TestDataQuestion> testDataForProgram) {
        return  terminal.runByteCodeProgram(NAME_VM, nameFile, FILE_EXTENSION, testDataForProgram);
    }
}

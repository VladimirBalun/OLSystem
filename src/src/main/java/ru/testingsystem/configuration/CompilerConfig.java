package ru.testingsystem.configuration;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.testingsystem.checkingTask.compilers.CompilerCpp;
import ru.testingsystem.checkingTask.compilers.CompilerJava;
import ru.testingsystem.checkingTask.interpreters.InterpreterPython;
import ru.testingsystem.data.service.BasicDataService;
import ru.testingsystem.checkingTask.Program;
import ru.testingsystem.checkingTask.compilers.Compiler;
import ru.testingsystem.checkingTask.compilers.CompilerC;

import java.util.Map;

@Log4j
@Configuration
public class CompilerConfig {

    @Autowired
    private BasicDataService basicDataService;
    @Autowired
    private Map<String, String> programmingLanguages;

    @Bean
    public Program programForCheckingPrograms(){
        String curLanguage = basicDataService.getProgrammingLanguageOlympiad();
        final String CLanguage = programmingLanguages.get("C");
        String CppLanguage = programmingLanguages.get("Cpp");
        String JavaLanguage = programmingLanguages.get("Java");
        String PythonLanguage = programmingLanguages.get("Python");
        if(curLanguage.equals(CLanguage)) {
            log.info("Was selected C language for passing Olympiad");
            return new CompilerC();
        }
        if(curLanguage.equals(CppLanguage)) {
            log.info("Was selected C++ language for passing Olympiad");
            return new CompilerCpp();
        }
        if(curLanguage.equals(JavaLanguage)) {
            log.info("Was selected Java language for passing Olympiad");
            return new CompilerJava();
        }
        if(curLanguage.equals(PythonLanguage)) {
            log.info("Was selected Python language for passing Olympiad");
            return new InterpreterPython();
        }
        return new CompilerC();
    }

    @Bean
    public Compiler compilerC(){
        return new CompilerC();
    }

    @Bean
    public Compiler compilerCpp(){
        return new CompilerCpp();
    }

    @Bean
    public Compiler compilerJava(){
        return new CompilerJava();
    }

    @Bean
    public InterpreterPython interpreterPython(){
        return new InterpreterPython();
    }

}


package ru.testingsystem.configuration;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.testingsystem.checkingTask.compilers.CompilerCpp;
import ru.testingsystem.checkingTask.compilers.CompilerJava;
import ru.testingsystem.checkingTask.interpreters.InterpreterPython;
import ru.testingsystem.data.service.BasicDataService;
import ru.testingsystem.checkingTask.Program;
import ru.testingsystem.checkingTask.compilers.Compiler;
import ru.testingsystem.checkingTask.compilers.CompilerC;

@Log4j
@Configuration
@ComponentScan("ru.testingsystem.checkingTask")
public class ProgrammingLanguageConfig {

    @Autowired
    private BasicDataService basicDataService;

    private static final String C_LANGUAGE = "C";
    private static final String CPP_LANGUAGE = "Cpp";
    private static final String JAVA_LANGUAGE = "Java";
    private static final String PYTHON_LANGUAGE = "Python";

    @Bean
    public Program languageForPassingOlympiad(){
        String curLanguage = basicDataService.getProgrammingLanguageOlympiad();
        if(curLanguage.equals(C_LANGUAGE)) {
            log.info("Was selected C languageForPassingOlympiad for passing Olympiad");
            return new CompilerC();
        }
        if(curLanguage.equals(CPP_LANGUAGE)) {
            log.info("Was selected C++ languageForPassingOlympiad for passing Olympiad");
            return new CompilerCpp();
        }
        if(curLanguage.equals(JAVA_LANGUAGE)) {
            log.info("Was selected Java languageForPassingOlympiad for passing Olympiad");
            return new CompilerJava();
        }
        if(curLanguage.equals(PYTHON_LANGUAGE)) {
            log.info("Was selected Python languageForPassingOlympiad for passing Olympiad");
            return new InterpreterPython();
        }
        return new CompilerC();
    }

    @Bean
    public Compiler languageC(){
        return new CompilerC();
    }

    @Bean
    public Compiler languageCpp(){
        return new CompilerCpp();
    }

    @Bean
    public Compiler languageJava(){
        return new CompilerJava();
    }

    @Bean
    public InterpreterPython languagePython(){
        return new InterpreterPython();
    }

}


package ru.testingsystem.configuration;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.testingsystem.data.service.BasicDataService;
import ru.testingsystem.utils.compilers.ByteCodeInterpreterJava;
import ru.testingsystem.utils.compilers.Compiler;
import ru.testingsystem.utils.compilers.CompilerC;
import ru.testingsystem.utils.compilers.CompilerCpp;

import java.util.Map;

@Log4j
@Configuration
public class CompilerConfig {

    @Autowired
    private BasicDataService basicDataService;
    @Autowired
    private Map<String, String> programmingLanguages;

    @Bean
    public Compiler compilerOrInterpreterForOlympiad(){
        String curLanguage = basicDataService.getProgrammingLanguageOlympiad();
        String CLanguage = programmingLanguages.get("C");
        String CppLanguage = programmingLanguages.get("Cpp");
        String JavaLanguage = programmingLanguages.get("Java");

        if(curLanguage.equals(CLanguage)) {
            log.info("Was selected C language for passing Olympiad");
            return new CompilerC();
        }
        if (curLanguage.equals(CppLanguage)) {
            log.info("Was selected Cpp language for passing Olympiad");
            return new CompilerCpp();
        }
        if (curLanguage.equals(JavaLanguage)) {
            log.info("Was selected Java language for passing Olympiad");
            return new ByteCodeInterpreterJava();
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
    public Compiler byteCodeInterpreterJava(){
        return new ByteCodeInterpreterJava();
    }

}


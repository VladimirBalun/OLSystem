package ru.testingsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.testingsystem.olympiad.checking_task.compilers.Compiler;
import ru.testingsystem.olympiad.checking_task.compilers.CompilerC;
import ru.testingsystem.olympiad.checking_task.compilers.CompilerCpp;
import ru.testingsystem.olympiad.checking_task.compilers.CompilerJava;

@Configuration
public class CompilerConfig {

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

}


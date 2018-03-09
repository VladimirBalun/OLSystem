package ru.testingsystem.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.testingsystem.utils.compilers.Compiler;
import ru.testingsystem.utils.compilers.CompilerC;
import ru.testingsystem.utils.compilers.CompilerCpp;

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


}


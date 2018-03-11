package ru.testingsystem.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:programming_languages.properties")
public class ProgrammingLanguagesConfig {

    @Value("${c_language}")
    private String cLanguage;

    @Value("${cpp_language}")
    private String cppLanguage;

    @Value("${java_language}")
    private String javaLanguage;

    @Bean
    public Map<String, String> languages(){
        Map<String, String> programmingLanguages = new HashMap<>();
        programmingLanguages.put("C", cLanguage);
        programmingLanguages.put("Cpp", cppLanguage);
        programmingLanguages.put("Java", javaLanguage);
        return programmingLanguages;
    }

}
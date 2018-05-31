package ru.system.OLSystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import ru.system.OLSystem.authentication.Authentication;
import ru.system.OLSystem.authentication.AuthenticationImpl;
import ru.system.OLSystem.olympiad.Olympiad;
import ru.system.OLSystem.olympiad.OlympiadImpl;

@Configuration
@ComponentScan({"ru.system.OLSystem.olympiad", "ru.system.OLSystem.authentication"})
public class ApplicationConfig {

    @Bean
    public Authentication authentication(){
        return new AuthenticationImpl();
    }

    @Bean
//    @Scope(WebApplicationContext.SCOPE_SESSION)
    public Olympiad olympiad() {
        return new OlympiadImpl();
    }

}

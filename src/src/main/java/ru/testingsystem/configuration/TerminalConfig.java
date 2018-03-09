package ru.testingsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.testingsystem.utils.terminals.Terminal;
import ru.testingsystem.utils.terminals.LinuxTerminal;
import ru.testingsystem.utils.terminals.WindowsCommandLine;

@Configuration
public class TerminalConfig {

    @Bean
    public Terminal terminal(){
        String operatingSystem = System.getProperty("os.name");
        if(operatingSystem.startsWith("Windows")){
            return new WindowsCommandLine();
        } else {
            return new LinuxTerminal();
        }
    }

}

package ru.testingsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.testingsystem.olympiad.checking_task.terminals.Terminal;
import ru.testingsystem.olympiad.checking_task.terminals.LinuxTerminal;
import ru.testingsystem.olympiad.checking_task.terminals.WindowsCommandLine;

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

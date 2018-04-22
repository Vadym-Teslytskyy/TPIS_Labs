package ua.ippt.oop.lab2.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private CommandLine commandLine;
    @Override
    public void run(String... args){
        commandLine.runMenu();
    }
}

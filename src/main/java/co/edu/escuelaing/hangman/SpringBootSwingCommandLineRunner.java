package co.edu.escuelaing.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class SpringBootSwingCommandLineRunner implements CommandLineRunner {
    private final GUI gui;

    @Autowired
    public SpringBootSwingCommandLineRunner(GUI gui) {
        this.gui = gui;
    }


    @Override
    public void run(String... args) {
        //This boots up the GUI.
        EventQueue.invokeLater(() -> gui.play());
    }
}

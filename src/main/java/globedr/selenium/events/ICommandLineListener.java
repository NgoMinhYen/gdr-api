package globedr.selenium.events;

import java.io.BufferedReader;

public interface ICommandLineListener {
    void beforeRunCommandLine(String cmd);

    void afterRunCommandLine(String stdOutput, String stdError);

}

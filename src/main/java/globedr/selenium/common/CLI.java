package globedr.selenium.common;

import globedr.selenium.events.EventListener;
import org.testng.util.Strings;

import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLI {

    public String execute(String cmd) {

        StringBuilder error = new StringBuilder();
        StringBuilder out = new StringBuilder();
        Process proc = null;
        BufferedReader stdOutput = null;
        BufferedReader stdError = null;
        String s = null;
        EventListener.getEvent().beforeRunCommandLine(cmd);

        try {
            Runtime rt = Runtime.getRuntime();
            proc = rt.exec(cmd);

            stdOutput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            // read the output from the command
            while ((s = stdOutput.readLine()) != null) {
                out.append(s);
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                error.append(s);
            }

            EventListener.getEvent().afterRunCommandLine(out.toString(), error.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Strings.isNotNullAndNotEmpty(error.toString())) {
                //Warning
                System.out.println(error.toString());
            }

            proc.destroy();
        }


        return out.toString();
    }
}

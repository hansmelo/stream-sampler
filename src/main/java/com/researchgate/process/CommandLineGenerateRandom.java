package com.researchgate.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hansmelo
 */
public class CommandLineGenerateRandom implements GenerateRandom {

    private final String commandLine;

    public CommandLineGenerateRandom(String commandLine) {
        this.commandLine = commandLine;
    }

    @Override
    public String execute() {

        StringBuilder out = new StringBuilder();
        try {
            String[] cmd = {"/bin/sh", "-c", commandLine};
            final Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) {
                out.append(line);
            }
            int exitValue = process.waitFor();
            if (exitValue != 0) {
                Logger.getLogger(CommandLineGenerateRandom.class.getName()).log(Level.SEVERE, null, "Abnormal process termination");
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CommandLineGenerateRandom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out.toString();
    }
}

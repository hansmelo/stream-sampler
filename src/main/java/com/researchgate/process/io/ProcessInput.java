package com.researchgate.process.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hansmelo
 */
public class ProcessInput {

    private static final String PATTERN_INTERN_CMD = "(\\s*)(.*?)(\\s*)(\\d+)";
    private final String command;

    public ProcessInput(String command) {
        this.command = command;
    }

    public CommandInput extract() {
        CommandInput commandInput = null;
        int lastPipe = command.lastIndexOf("|");
        String commandLine = (lastPipe != -1) ? command.substring(0, lastPipe) : "";
        Pattern p = Pattern.compile(PATTERN_INTERN_CMD);
        Matcher m = p.matcher(command.substring(lastPipe + 1));
        while (m.find()) {
            commandInput = new CommandInput(m.group(2), m.group(4), commandLine);
        }
        return commandInput;
    }
}

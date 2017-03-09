package com.researchgate.process.io;

/**
 *
 * @author hansmelo
 */
public class CommandInput {

    private final String type;
    private final int size;
    private final String commandLine;

    public CommandInput(String type, String size, String commandLine) {
        this.type = type;
        this.commandLine = commandLine;
        this.size = Integer.parseInt(size);
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public String getCommandLine() {
        return commandLine;
    }

    public Boolean isNotValid() {
        return type == null || "".equals(type) || size <= 0;
    }

    @Override
    public String toString() {
        return type + " " + size + " " + commandLine;
    }

}

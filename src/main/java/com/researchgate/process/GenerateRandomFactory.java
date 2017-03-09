package com.researchgate.process;

import com.researchgate.process.io.CommandInput;

/**
 *
 * @author hansmelo
 */
public class GenerateRandomFactory {

    public static final String COMMAND_LINE_TYPE = "stream-sampler";
    public static final String HTTP_TYPE = "http-stream-sampler";
    public static final String INTERN_TYPE = "intern-stream-sampler";

    public static GenerateRandom getGenerateRandom(CommandInput cmdInput) {
        GenerateRandom generateRandom = null;
        switch (cmdInput.getType()) {
            case COMMAND_LINE_TYPE:
                generateRandom = new CommandLineGenerateRandom(cmdInput.getCommandLine());
                break;
            case HTTP_TYPE:
                generateRandom = new HttpGenerateRandom(cmdInput.getSize());
                break;
            case INTERN_TYPE:
                generateRandom = new InternGenerateRandon(cmdInput.getSize());
                break;
        }
        return generateRandom;
    }
}

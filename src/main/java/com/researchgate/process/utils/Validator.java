package com.researchgate.process.utils;

import com.researchgate.process.GenerateRandom;
import com.researchgate.process.io.CommandInput;

/**
 *
 * @author hansmelo
 */
public class Validator {

    public static final String INVALID_CMD = "\nProblem with command: ";

    public static void checkCommandInputIsValid(CommandInput cmdInput, String inputUser) {
        if (cmdInput == null || cmdInput.isNotValid()) {
            invalidCommand(inputUser);
        }
    }

    public static void checkGenerateRadomIsValid(GenerateRandom generateRandom, String inputUser) {
        if (generateRandom == null) {
            invalidCommand(inputUser);
        }
    }

    public static void checkNewWordRadomIsValid(String newWord, String inputUser) {
        if (newWord == null || "".equals(newWord)) {
            invalidCommand(inputUser);
        }
    }

    public static void invalidCommand(String inputUser) {
        System.out.println(INVALID_CMD + inputUser);

        System.out.println("************************************************************************************************************");
        System.err.println("The pattern of command:");
        System.out.println("java -jar target/stream-sampler-1.0-SNAPSHOT.jar \"{CommandLine | }(Optional) {random-type} {size}");
        System.out.println("Examples of input:");
        System.out.println("java -jar target/stream-sampler-1.0-SNAPSHOT.jar \"intern-stream-sampler 120\"");
        System.out.println("java -jar target/stream-sampler-1.0-SNAPSHOT.jar \"http-stream-sampler 10\"");
        System.out.println("java -jar target/stream-sampler-1.0-SNAPSHOT.jar \"dd if=/dev/urandom count=100 bs=1MB | base64 | stream-sampler 150\"\n");
        System.out.println("Obs: In the http-stream-sampler the size cannot be bigger than 20\n");
        System.exit(0);
    }
}

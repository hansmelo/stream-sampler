package com.researchgate;

import com.researchgate.process.GenerateRandomFactory;
import com.researchgate.process.io.ProcessOutput;
import com.researchgate.process.GenerateRandom;
import com.researchgate.process.io.CommandInput;
import com.researchgate.process.io.ProcessInput;
import static com.researchgate.process.utils.Validator.*;

/**
 *
 * @author hansmelo
 */
public class App {

    public static void main(String[] args) {

        String inputUser = args[0];
        ProcessInput processInput = new ProcessInput(inputUser);

        CommandInput cmdInput = processInput.extract();
        checkCommandInputIsValid(cmdInput, inputUser);

        GenerateRandom generateRandom = GenerateRandomFactory.getGenerateRandom(cmdInput);
        checkGenerateRadomIsValid(generateRandom, inputUser);

        String word = generateRandom.execute();
        checkNewWordRadomIsValid(word, inputUser);

        ProcessOutput process = new ProcessOutput(word, cmdInput.getSize());
        System.out.println("Random Sample: " + process.execute());
    }
}

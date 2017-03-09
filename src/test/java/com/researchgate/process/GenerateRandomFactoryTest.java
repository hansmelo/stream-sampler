package com.researchgate.process;

import com.researchgate.process.io.CommandInput;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author hansmelo
 */
public class GenerateRandomFactoryTest {

    public static final String SIZE = "10";
    public static final String CMD = "";
    private GenerateRandom generateRandom;

    @Test
    void testGetCommandLindRandom() {
        CommandInput commandInput = new CommandInput(GenerateRandomFactory.COMMAND_LINE_TYPE, SIZE, CMD);
        generateRandom = GenerateRandomFactory.getGenerateRandom(commandInput);
        assertTrue(generateRandom instanceof CommandLineGenerateRandom);
    }

    @Test
    void testGetHttpGenerateRandom() {
        CommandInput commandInput = new CommandInput(GenerateRandomFactory.HTTP_TYPE, SIZE, CMD);
        generateRandom = GenerateRandomFactory.getGenerateRandom(commandInput);
        assertTrue(generateRandom instanceof HttpGenerateRandom);
    }

    @Test
    void testGetInternGenerateRandom() {
        CommandInput commandInput = new CommandInput(GenerateRandomFactory.INTERN_TYPE, SIZE, CMD);
        generateRandom = GenerateRandomFactory.getGenerateRandom(commandInput);
        assertTrue(generateRandom instanceof InternGenerateRandon);
    }

    @Test
    void testGetTypeNotExist() {
        CommandInput commandInput = new CommandInput("NotExistCmd", SIZE, CMD);
        generateRandom = GenerateRandomFactory.getGenerateRandom(commandInput);
        assertTrue(generateRandom == null);
    }

}

package com.researchgate.process;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hansmelo
 */
public class CommandLineGenerateRandomTest {

    private CommandLineGenerateRandom commandLineGenerateRandom;
    private static final String CMD_LINE = "dd if=/dev/urandom count=1 bs=10KB | base64";
    private String result;

    @BeforeEach
    void init() {
        commandLineGenerateRandom = new CommandLineGenerateRandom(CMD_LINE);
        result = commandLineGenerateRandom.execute();
    }

    @Test
    void testExecuteGenerateRandomValues() {
        String result2 = commandLineGenerateRandom.execute();
        assertNotEquals(result, result2);
    }

    @Test
    void testExecuteGenerateRandomValuesTheSameSize() {
        String result2 = commandLineGenerateRandom.execute();
        assertEquals(result.length(), result2.length());
    }
}

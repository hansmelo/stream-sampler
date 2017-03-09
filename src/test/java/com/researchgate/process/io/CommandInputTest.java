package com.researchgate.process.io;

import com.researchgate.process.GenerateRandomFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hansmelo
 */
public class CommandInputTest {

    private CommandInput commandInput;
    private static final String TYPE = GenerateRandomFactory.COMMAND_LINE_TYPE;
    private static final String SIZE = "10";
    private static final String CMD = "dd if=/dev/urandom count=100 bs=1MB | base64 | stream-sampler 150";

    @BeforeEach
    void init() {
        commandInput = new CommandInput(TYPE, SIZE, CMD);
    }

    @Test
    public void testGetType() {
        assertEquals(TYPE, commandInput.getType());
    }

    @Test
    public void testGetSize() {
        assertEquals(Integer.parseInt(SIZE), commandInput.getSize());
    }

    @Test
    public void testGetCommandLine() {
        assertEquals(CMD, commandInput.getCommandLine());
    }

    @Test
    public void testIsNotValid() {
        CommandInput cmdInput = new CommandInput(null, "0", "");
        assertTrue(cmdInput.isNotValid());
    }

    @Test
    public void testToString() {
        String expResult = TYPE + " " + SIZE + " " + CMD;
        assertEquals(expResult, commandInput.toString());
    }

}

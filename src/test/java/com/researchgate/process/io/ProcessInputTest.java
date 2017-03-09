package com.researchgate.process.io;

import com.researchgate.process.GenerateRandomFactory;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hansmelo
 */
public class ProcessInputTest {

    private static final String INPUT_CMD = "dd if=/dev/urandom count=100 bs=1MB | base64 ";
    private static final int SIZE = 150;
    private static final String STREAM_SAMPLER = GenerateRandomFactory.COMMAND_LINE_TYPE;
    private static final String HTTP_SAMPLER = GenerateRandomFactory.HTTP_TYPE;
    private static final String INTERN_SAMPLER = GenerateRandomFactory.INTERN_TYPE;
    private static final String INPUT_STREAM_SAMPLER = INPUT_CMD + "| " + STREAM_SAMPLER + " " + SIZE;
    private static final String INPUT_HTTP_SAMPLER = HTTP_SAMPLER + " " + SIZE;
    private static final String INPUT_INTERN_SAMPLER = INTERN_SAMPLER + " " + SIZE;

    @Test
    void testExecuteForInputTypeCmdLine() {
        ProcessInput processInput = new ProcessInput(INPUT_STREAM_SAMPLER);
        CommandInput cmdInput = processInput.extract();
        Assertions.assertAll("commandLine",
                () -> assertEquals(cmdInput.getCommandLine(), INPUT_CMD),
                () -> assertEquals(cmdInput.getSize(), SIZE),
                () -> assertEquals(cmdInput.getType(), STREAM_SAMPLER)
        );
    }

    @Test
    void testExecuteForInputTypeHttp() {
        ProcessInput processInput = new ProcessInput(INPUT_HTTP_SAMPLER);
        CommandInput cmdInput = processInput.extract();
        Assertions.assertAll("httpCommand",
                () -> assertEquals(cmdInput.getCommandLine(), ""),
                () -> assertEquals(cmdInput.getSize(), SIZE),
                () -> assertEquals(cmdInput.getType(), HTTP_SAMPLER)
        );
    }

    @Test
    void testExecuteForInputTypeIntern() {
        ProcessInput processInput = new ProcessInput(INPUT_INTERN_SAMPLER);
        CommandInput cmdInput = processInput.extract();
        Assertions.assertAll("internCommand",
                () -> assertEquals(cmdInput.getCommandLine(), ""),
                () -> assertEquals(cmdInput.getSize(), SIZE),
                () -> assertEquals(cmdInput.getType(), INTERN_SAMPLER)
        );
    }
}

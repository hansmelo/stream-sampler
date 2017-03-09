package com.researchgate.process.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hansmelo
 */
public class ProcessOuputTest {

    private static final String WORD = "HyEOXnIOaXp4cyYqnqsfa0Nc7jqPnQNfNSaX+MFtm4Ljjb6ycR9WBVsN2YvYKlAdPblzfx3pjVPr";
    private static final int SIZE = 10;
    private ProcessOutput processOutput;
    private String newWord;

    @BeforeEach
    void init() {
        processOutput = new ProcessOutput(WORD, SIZE);
        newWord = processOutput.execute();
    }

    @Test
    void testRightSize() {
        assertEquals(SIZE, newWord.length());
    }

    @Test
    void testGenerateRandomNewWords() {
        String newWord2 = processOutput.execute();
        assertNotEquals(newWord, newWord2);
    }
}

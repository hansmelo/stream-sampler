package com.researchgate.process;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hansmelo
 */
public class HttpGenerateRandomTest {

    private HttpGenerateRandom httpGenerateRandom;
    private String result;

    @BeforeEach
    void init() {
        httpGenerateRandom = new HttpGenerateRandom(5);
        result = httpGenerateRandom.execute();
    }

    @Test
    void testExecuteRightSize() {
        assertEquals(result.length(), HttpGenerateRandom.SIZE);
    }

    @Test
    void testExecuteWrongSize() {
        assertNotEquals(result.length(), HttpGenerateRandom.SIZE + 1);
    }

    @Test
    void testGenerateRadomValues() {
        String result2 = httpGenerateRandom.execute();
        assertNotEquals(result, result2);
    }
}

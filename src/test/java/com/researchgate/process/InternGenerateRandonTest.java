package com.researchgate.process;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hansmelo
 */
public class InternGenerateRandonTest {

    private InternGenerateRandon internGenerateRandon;
    private String result;
    private static final int SIZE = 10;

    @BeforeEach
    void init() {
        internGenerateRandon = new InternGenerateRandon(SIZE);
        result = internGenerateRandon.execute();
    }

    @Test
    public void testExecuteRightSize() {
        int expectSize = internGenerateRandon.SIZE_DEFAULT + SIZE;
        assertEquals(expectSize, result.length());
    }

    @Test
    public void testExecuteWrongSize() {
        int wrongSize = internGenerateRandon.SIZE_DEFAULT + SIZE + 1;
        assertNotEquals(wrongSize, result.length());
    }

    @Test
    public void testGenerateRandomValues() {
        String result2 = internGenerateRandon.execute();
        assertNotEquals(result, result2);
    }

}

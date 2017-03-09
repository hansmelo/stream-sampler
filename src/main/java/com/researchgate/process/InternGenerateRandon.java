package com.researchgate.process;

import java.util.Random;

/**
 *
 * @author hansmelo
 */
public class InternGenerateRandon implements GenerateRandom {

    public static final int SIZE_DEFAULT = 100;
    private int size;

    public InternGenerateRandon(int size) {
        this.size = size + SIZE_DEFAULT;
    }

    @Override
    public String execute() {
        return generateRandomString(size);
    }

    //http://www.rationaljava.com/2015/06/java8-generate-random-string-in-one-line.html
    private static String generateRandomString(int length) {
        return new Random().ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}

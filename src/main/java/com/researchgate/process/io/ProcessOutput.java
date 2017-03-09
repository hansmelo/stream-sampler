package com.researchgate.process.io;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author hansmelo
 */
public class ProcessOutput {

    private final String inputGenerate;
    private final int size;

    public ProcessOutput(String inputGenerate, int size) {
        this.inputGenerate = inputGenerate;
        this.size = size;
    }

    public String execute() {
        StringBuilder newString = new StringBuilder();
        Set<Integer> indexes = getIndexes();
        indexes.forEach((index) -> newString.append(inputGenerate.charAt(index)));
        return newString.toString();
    }

    private Set<Integer> getIndexes() {
        HashSet<Integer> indexesNewString = new HashSet<>();
        while (indexesNewString.size() < size) {
            Integer randomNum = ThreadLocalRandom.current().nextInt(0, inputGenerate.length());
            indexesNewString.add(randomNum);
        }
        return indexesNewString;
    }
}

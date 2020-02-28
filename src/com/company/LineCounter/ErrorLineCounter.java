package com.company.LineCounter;

public class ErrorLineCounter extends AllLineCounter {

    public ErrorLineCounter(Object fileInputStream) {
        super(fileInputStream);
    }

    @Override
    public int count() {
        String word = "ERROR";

        return read(word);

    }
}

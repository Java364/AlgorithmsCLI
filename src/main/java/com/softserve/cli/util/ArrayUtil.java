package com.softserve.cli.util;

import com.softserve.cli.SequenceFormatException;

public class ArrayUtil {
    private static final String SPACE = " ";
    public static int[] parseIntegerSequence(String seq) throws SequenceFormatException {
        if (seq.contains(",") || !seq.contains(SPACE))
            throw new SequenceFormatException(wrongFormatMsg(seq));
        String[] stringifiedNumbers = seq.trim().replaceAll(SPACE + "+", SPACE).split(SPACE);
        int[] parsedSequence = new int[stringifiedNumbers.length];
        try {
            for (int i = 0; i < stringifiedNumbers.length; i++) {
                int number = Integer.parseInt(stringifiedNumbers[i]);
                parsedSequence[i] = number;
            }
        } catch (NumberFormatException nfe) {
            throw new SequenceFormatException(wrongFormatMsg(seq), nfe);
        }
        return  parsedSequence;
    }

    private static String wrongFormatMsg(String seq) {
        return String.format("Unknown sequence format: '%s'. Can't parse.", seq);
    }
}

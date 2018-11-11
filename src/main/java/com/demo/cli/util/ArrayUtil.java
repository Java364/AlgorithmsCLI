package com.demo.cli.util;

import com.demo.cli.SequenceFormatException;

import java.util.Arrays;

public class ArrayUtil {
    public static int[] parseIntegerSequence(String seq) throws SequenceFormatException {
        if (seq.contains(",") || !seq.contains(" "))
            throw new SequenceFormatException(wrongFormatMsg(seq));
        String[] stringifiedNumbers = seq.trim().replaceAll(" +", " ").split(" ");
        System.out.println(Arrays.toString(stringifiedNumbers));
        int[] parsedSequence = new int[stringifiedNumbers.length];
        try {
            for (int i = 0; i < stringifiedNumbers.length; i++) {
                int number = (int) Double.parseDouble(stringifiedNumbers[i]);
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

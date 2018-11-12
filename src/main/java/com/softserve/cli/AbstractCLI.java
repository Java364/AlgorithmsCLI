package com.softserve.cli;

import com.softserve.cli.option.AlgorithmOption;
import com.softserve.cli.util.ArrayUtil;

import java.util.Scanner;

public abstract class AbstractCLI implements CommandLineInterface {
    protected static final String BAD_SEQUENCE_FORMAT_MSG = "Oops can't evaluate sequence!";
    protected static final String INVALID_NUMBER_MSG = "You've entered invalid number.";

    protected Scanner         prompt;
    protected AlgorithmOption algorithmOption;
    protected int[]           parsedSequence;

    public AbstractCLI(Scanner prompt) {
        this.prompt = prompt;
    }

    protected boolean promptSequence() {
        System.out.print("Please enter sequence (e.g '1 2 3'): ");
        String sequence = prompt.nextLine();
        try {
            this.parsedSequence = ArrayUtil.parseIntegerSequence(sequence);
        } catch (SequenceFormatException afe) {
            // TODO should be logged
            return false;
        }
        return true;
    }

    public void setAlgorithmOption(AlgorithmOption algorithmOption) {
        this.algorithmOption = algorithmOption;
    }
}

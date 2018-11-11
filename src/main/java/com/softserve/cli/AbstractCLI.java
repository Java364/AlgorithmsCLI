package com.softserve.cli;

import com.softserve.cli.option.AlgorithmOption;
import com.softserve.cli.util.ArrayUtil;

import java.util.Scanner;

public abstract class AbstractCLI implements CommandLineInterface {
    protected Scanner         prompt;
    protected AlgorithmOption algorithmOption;
    protected int[]           parsedSequence;

    public AbstractCLI(Scanner prompt) {
        this.prompt = prompt;
    }

    protected boolean promptSequence() {
        System.out.print("please enter sequence: ");
        String sequence = prompt.nextLine();
        try {
            this.parsedSequence = ArrayUtil.parseIntegerSequence(sequence);
        } catch (SequenceFormatException afe) {
            // TODO probably should be logged
            System.out.println("Oops can't evaluate sequence!");
            return false;
        }
        return true;
    }

    public void setAlgorithmOption(AlgorithmOption algorithmOption) {
        this.algorithmOption = algorithmOption;
    }
}

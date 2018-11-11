package com.demo;

import com.demo.cli.UserPrompt;
import com.sun.media.sound.SoftTuning;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InvalidInputHandler {
    public static void promptAgainIfInvalidValue(UserPrompt userPrompt) {
        while (!userPrompt.prompt()) {
            System.out.println("Please try again!");
        }
    }

    public static void promptIntAgainIfInvalid(Scanner prompt) {
            while (!prompt.hasNextInt()) {
                System.out.println("You've entered non-integer number.");
                System.out.println("Please try again!");
                prompt.nextLine();
            }
    }
}

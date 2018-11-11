package com.softserve;

import com.softserve.cli.UserPrompt;

public class InvalidInputHandler {
    public static void promptIfInvalidValue(UserPrompt userPrompt) {
        while (!userPrompt.prompt()) {
            System.out.println("Please try again!");

        }
    }
}

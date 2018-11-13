package com.softserve.cli;

public class InvalidInputHandler {
    public static void promptIfInvalidValue(UserPrompt userPrompt, String errorMsg) {
        try {
            while (!userPrompt.prompt()) {
                System.out.println(errorMsg);
            }
        } catch (RuntimeException e) {
            // TODO exception must be logged
            System.out.println(errorMsg);
            userPrompt.prompt();
        }
    }
}

package com.softserve.cli;

public class InvalidInputHandler {
    public static void promptIfInvalidValue(UserPrompt userPrompt, String errorMsg) {
        while (!userPrompt.prompt()) {
            System.out.println(errorMsg);
        }
    }
}

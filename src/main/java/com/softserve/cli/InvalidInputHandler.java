package com.softserve.cli;

import java.util.function.BooleanSupplier;

public class InvalidInputHandler {
    public static void promptIfInvalidValue(BooleanSupplier promptSupplier, String errorMsg) {
        try {
            while (!promptSupplier.getAsBoolean()) {
                System.out.println(errorMsg);
            }
        } catch (RuntimeException e) {
            // TODO exception must be logged
            System.out.println(errorMsg);
            promptIfInvalidValue(promptSupplier, errorMsg);
        }
    }
}

package com.softserve.cli.util;

import java.util.Scanner;

public final class InputUtil {
    private InputUtil() {}
    public static int readIntValue(Scanner prompt) {
        final int option = prompt.nextInt();
        prompt.nextLine();
        return option;
    }

    public static boolean hasNextInt(Scanner prompt) {
        boolean hasNextInt = prompt.hasNextInt();
        if (!hasNextInt)
            prompt.nextLine();
        return hasNextInt;
    }
}

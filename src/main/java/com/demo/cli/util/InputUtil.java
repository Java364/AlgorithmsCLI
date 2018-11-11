package com.demo.cli.util;

import java.util.Scanner;

public final class InputUtil {
    private InputUtil() {}
    public static int readIntValue(Scanner prompt) {
        int option = prompt.nextInt();
        prompt.nextLine();
        return option;
    }
}

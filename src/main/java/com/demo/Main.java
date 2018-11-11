package com.demo;

import com.demo.cli.impl.MainCommandLineInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new MainCommandLineInterface(scanner).run();
        }
    }
}

package com.softserve.cli.option;

public enum CommonAlgorithmOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    SORT("Sort menu", "Entering sorting menu..."),
    FIBONACCI("Fibonacci",
              "The goal: To find which is the member of position n in Fibonacci sequence"),
    LONGEST_SUBSEQUENCE("Longest subsequence with difference one",
                        "The goal: To find how many numbers we have with difference one in the maximum sub sequence "),
    TILING_THE_FLOOR("Ways to tile the floor", "Goal: Given a floor of size n x m and tiles of size 1 x m. The problem is to count the number of ways to tile the given floor using 1 x m tiles. A tile can either be placed horizontally or vertically.");

    private String algorithmName;
    private String algorithmDescription;

    CommonAlgorithmOption(String algorithmName, String algorithmDescription) {
        this.algorithmName = algorithmName;
        this.algorithmDescription = algorithmDescription;
    }

    @Override
    public String getOptionName() {
        return this.algorithmName;
    }

    @Override
    public String getOptionDescription() {
        return this.algorithmDescription;
    }
}

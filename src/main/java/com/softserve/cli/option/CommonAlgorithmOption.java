package com.softserve.cli.option;

public enum CommonAlgorithmOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    SORT("Sort menu", "Entering sorting menu..."),
    FIBONACCI("Fibonacci",
              "The goal: To find which is the member of position n in Fibonacci sequence"),
    LONGEST_SUBSEQUENCE("Longest subsequence with difference one",
                        "The goal: To find how many numbers we have with difference one "
                        + "in the maximum sub sequence"),
    PATH_WITHOUT_CROSSING("Paths without crossing", "The goal: Program to count number "
    		+ "of ways to connect n (where n is even) "
    		+ "points on a circle such that no two connecting lines cross each other "
    		+ "and every point is connected with one other point."),
    WAYS_TO_SUM_USING_ARRAY("Ways to sum to N using array elements with repetition",
    		"The goal: To find how many ways we have "
    		+ "to represent one number with a given array of numbers");

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

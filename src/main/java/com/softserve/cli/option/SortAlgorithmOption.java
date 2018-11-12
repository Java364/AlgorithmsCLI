package com.softserve.cli.option;

public enum SortAlgorithmOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    MERGE_SORT("Merge sort",
               "Replace this with the description of the algorithm"),
    COUNTING_SORT("Counting Sort", "You choose Counting Sort");

    private String algorithmName;
    private String algorithmDescription;

    SortAlgorithmOption(String algorithmName, String algorithmDescription) {
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

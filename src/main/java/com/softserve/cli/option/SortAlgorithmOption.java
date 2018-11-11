package com.softserve.cli.option;

public enum SortAlgorithmOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    MERGE_SORT("Merge sort",
               "Replace this with the description of the algorithm"),
    COUNTING_SORT("Counting Sort", "Yoy choose Counting Sort");

    private String algorithmName;
    private String algorithmDescription;

    SortAlgorithmOption(String algorithmName, String algorithmDescription) {
        this.algorithmName = algorithmName;
        this.algorithmDescription = algorithmDescription;
    }

    @Override
    public String getAlgorithmName() {
        return this.algorithmName;
    }

    @Override
    public String getAlgorithmDescription() {
        return this.algorithmDescription;
    }
}

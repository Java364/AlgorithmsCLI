package com.softserve.cli.option;

public enum SortAlgorithmsOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    MERGE_SORT("Merge sort",
               "Replace this with the description of the algorithm");

    private String algorithmName;
    private String algorithmDescription;

    SortAlgorithmsOption(String algorithmName, String algorithmDescription) {
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

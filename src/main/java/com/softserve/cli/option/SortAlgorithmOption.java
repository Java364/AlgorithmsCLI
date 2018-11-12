package com.softserve.cli.option;

public enum SortAlgorithmOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    MERGE_SORT("Merge sort", "Sort your array using Merge sort"),
    QUICK_SORT("Quick sort","Sort your array using Quick sort "),
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

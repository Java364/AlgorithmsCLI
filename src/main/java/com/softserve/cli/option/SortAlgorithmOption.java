package com.softserve.cli.option;

public enum SortAlgorithmOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    MERGE_SORT("Merge sort",
               "Replace this with the description of the algorithm"),
    COUNTING_SORT("Counting Sort", "Yoy choose Counting Sort"),
    INSERTION_SORT("Insertion sort", "You choose Insertion Sort"),
    QUICK_SORT("Quick sort", "Sort your array using Quick sort "),
    BUCKET_SORT("Bucket sort", "Sort your array using Bucket sort");

    private String optionName;
    private String optionDescription;

    SortAlgorithmOption(String optionName, String optionDescription) {
        this.optionName = optionName;
        this.optionDescription = optionDescription;
    }

    @Override
    public String getOptionName() {
        return this.optionName;
    }

    @Override
    public String getOptionDescription() {
        return this.optionDescription;
    }
}

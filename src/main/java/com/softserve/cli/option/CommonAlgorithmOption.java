package com.softserve.cli.option;

public enum CommonAlgorithmOption implements AlgorithmOption {
    EXIT("Exit", "Exiting..."),
    SORT("Sort menu", "Entering sorting menu..."),
    FIBONACCI("Fibonacci",
              "The goal: To find which is the member of position n in Fibonacci sequence"),
    LONGEST_SUBSEQUENCE("Longest subsequence with difference one",
                        "The goal: To find how many numbers we have with difference one in the maximum sub sequence "),
    TILING_THE_FLOOR("Ways to tile the floor", "Goal: Given a floor of size n x m and tiles of size 1 x m. The problem is to count the number of ways to tile the given floor using 1 x m tiles. A tile can either be placed horizontally or vertically."),
    PATH_WITHOUT_CROSSING("Paths without crossing", "The goal: Program to count number "
    		+ "of ways to connect n (where n is even) "
    		+ "points on a circle such that no two connecting lines cross each other "
    		+ "and every point is connected with one other point."),
    WAYS_TO_SUM_USING_ARRAY("Ways to sum to N using array elements with repetition",
    		"The goal: To find how many ways we have "
    		+ "to represent one number with a given array of numbers"),
    PAINTING_THE_FENCE("Painting the fence", "The goal: Given a fence with n posts and k colors," 
    		+ " find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. "),
    OPTIMIZED_PAINTING_FENCE("Painting fence", "Goal: Given a fence with n posts and k colors, " 
    		+ "find out the number of ways of painting the fence such that at most 2 adjacent "
    		+ "posts have the same color. "),
    MAX_POSSIBLE_DAILY_TASKS("Work to be with High-effort or with Low-effort", 
			"The goal: We have n days and for each day (d) you could either perform a high effort"
    		+ " tasks (hi) or a low effort tasks (li) or no task with the constraint (it is"
    		+ " written 0) that you can choose a high-effort tasks only if you chose no task on "
    		+ "the previous day. Write a program to find the maximum amount of cost you can perform "
    		+ "within these n days."),
    FRIEND_PAIRS("Friend pairs", "The goal: To find in how many ways is possible to calculate n with positive integers. "),
    WAYS_TO_WRITE_N_AS_SUM("Ways to write n as sum of two or more positive integers", 
	         "The goal: To find in how many ways is possible to calculate n with positive integers.");
    private String optionName;
    private String optionDescription;

    CommonAlgorithmOption(String optionName, String optionDescription) {
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

package com.himashi.algorithm.sumOfTwoIntegers;

public class TwoSumSortedArray {
    public int[] twoSum (int[] numbers, int target){
        int first = 0;
        int last = numbers.length-1;

        while(last> first){
            int sum = numbers[first]+numbers[last];
            if (sum > target)
                last -= 1;
            else if (sum < target)
                first += 1;
            else
                return new int[] {first, last};
        }

        return new int[] {first, last};
    }
}

package com.himashi.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and a value,
 * determine if there are any two integers in the array whose sum is equal to the given value.
 * Return true if the sum exists and return false if it does not.
 * Consider this array and the target sums:
 *
 * array = 5, 7, 1, 2, 8, 4, 3
 * targetSum1 = 10
 * targetSum2 = 19
 *
 *
 * Runtime complexity = O(n)
 * Runtime Complexity = O(n)
 *
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int[] numberList = {5, 7, 1, 2, 8, 4, 3};
        int targetSum1 = 10;
        int targetSum2 = 19;

        System.out.println(findValueAddedUpToTargetSum(numberList, targetSum1));
        System.out.println(findValueAddedUpToTargetSum(numberList, targetSum2));
    }

    private static boolean findValueAddedUpToTargetSum(int[] numberList, int targetSum) {
        Set<Integer> hashSet = new HashSet<>();
        for (int val:numberList) {
            if (hashSet.contains(targetSum- val))
                return true;
            hashSet.add(val);

        }
        return false;
    }
}

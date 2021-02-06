package com.himashi.algorithm.sumOfTwoIntegers;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            if (numberMap.containsKey(nums[i])){
                return new int[] {numberMap.get(nums[i]), i};
            }

            numberMap.put(target-nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int[] result = twoSum(nums, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

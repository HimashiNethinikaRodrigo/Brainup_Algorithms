package com.himashi.algorithm.sumOfTwoIntegers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum (int[] numbers, int target){
        int[] resultArray = new int[2];

        if (numbers.length< 2) return resultArray;

        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int currentValue = numbers[i];
            if(dataMap.containsKey(currentValue)){
                resultArray[0] = dataMap.get(currentValue);
                resultArray[1] = i;
                return resultArray;
            }
            if (currentValue> target)
                continue;

            dataMap.put(target-currentValue, i);
        }

        return resultArray;
    }
}

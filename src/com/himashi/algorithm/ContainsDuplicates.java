package com.himashi.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    private static boolean isContainDuplicates(int[] array) {

        if (array.length == 1) return false;
        long startTime = System.nanoTime();

        // Method 1
//        Set<Integer> valueSet = new HashSet<>();
//        for (int value: array) {
//            if (valueSet.contains(value)){
//                return true;
//            }
//            valueSet.add(value);
//        }


        // Method 2
        Arrays.sort(array);
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == array[i+1])
                return true;
        }


        System.out.println(System.nanoTime()- startTime);
        return false;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 1};
        int[] array2 = {1, 2, 3, 4};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 1};

        System.out.println(isContainDuplicates(array1));
        System.out.println(isContainDuplicates(array2));
        System.out.println(isContainDuplicates(array3));
    }
}

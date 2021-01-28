package com.himashi.algorithm;
/**
 * You are given an array of positive numbers from 1 to n,
 * such that all numbers from 1 to n are present except one number x.
 * You have to find x.
 * The input array is not sorted.
 * Number list = 3,7,1,2,8,4,5
 * n= 8
 * Missing number = 6
 *
 * Runtime complexity = O(n)
 *
 */


public class MissingNumber {

    public static void main(String[] args) {
        int n = 8;
        int[] numberList = {3,7,1,2,8,4,5};

        System.out.println(findMissingNumber(n, numberList));;
    }

    private static int findMissingNumber(int n, int[] numberList) {
        int sumOfElements =0;
        for (int val: numberList) {
            sumOfElements+=val;
        }
        final int expectedSum = sumOfArithmeticSeries(n);
        return expectedSum - sumOfElements;
    }

    private static int sumOfArithmeticSeries(int n) {
//        sum of arithmetic series - ((n/2) * (2a+(n-1)d))
//        a - First term
//        d - Common difference
//        n - No of terms
        return (n/2)*(2+(n-1));
    }
}

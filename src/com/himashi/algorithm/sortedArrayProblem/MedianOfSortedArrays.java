package com.himashi.algorithm.sortedArrayProblem;

import java.util.ArrayList;
import java.util.List;

public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0.0;
        List<Integer> mergedArray = new ArrayList<>();
        int i = 0;
        int j =0;
        while (i< nums1.length && j< nums2.length){
            if (nums1[i] < nums2 [j]) {
                mergedArray.add(nums1[i]);
                i++;
            }
            else {
                mergedArray.add(nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            mergedArray.add(nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            mergedArray.add(nums2[j]);
            j++;
        }

        int midIndex = mergedArray.size()/2;
        if (mergedArray.size()%2 != 0)
            return mergedArray.get(midIndex) ;

        return (mergedArray.get(midIndex)+ mergedArray.get(midIndex-1))/2.0;
    }

    public static void main(String[] args) {
        int [] nums1 = {};
        int [] nums2 = {};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

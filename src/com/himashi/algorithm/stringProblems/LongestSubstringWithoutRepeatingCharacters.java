package com.himashi.algorithm.stringProblems;

import java.util.Set;
import java.util.TreeSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> dataSet = new TreeSet<>();
        if (s == null || s.length() == 0) return 0;
        int max = 1;
        int start =0, end = 0;

        while (end < s.length()){
            if (!dataSet.contains(s.charAt(end))) {
                dataSet.add(s.charAt(end));
                end++;
                max = Math.max(dataSet.size(), max);
            } else {
                dataSet.remove(s.charAt(start));
                start++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s2));
    }
}

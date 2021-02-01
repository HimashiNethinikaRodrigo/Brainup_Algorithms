package com.himashi.algorithm.wordbreakproblem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordBreakingDynamicImplementation {
    private static Set<String> dictionary = new HashSet<>();
    public static void main(String[] args) {
        String[] temp_dictionary = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
        Collections.addAll(dictionary, temp_dictionary);
        System.out.println(dictionary);
        System.out.println(wordBreak("ilikesamsung"));
    }

    private static boolean wordBreak(String s) {
        int size = s.length();
        if (size == 0) return true;

        boolean[] wb = new boolean[size+1];

        for (int i = 1; i < size+1; i++) {
            if(!wb[i] && dictionary.contains(s.substring(0, i)))
                wb[i] = true;

            if(wb[i]) {
                if (i == size)
                    return true;

                for (int j = i+1; j < size+1 ; j++) {
                    if (!wb[j] && dictionary.contains(s.substring(i, j)))
                        wb[j] = true;
                    if (j== size && wb[j])
                        return true;
                }
            }
        }
        return false;
    }
}

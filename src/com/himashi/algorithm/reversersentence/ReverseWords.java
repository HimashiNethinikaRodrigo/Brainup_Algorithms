package com.himashi.algorithm.reversersentence;

import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "Hello World";

        System.out.println(reverseWordsInSentence(sentence));
    }

    private static String  reverseWordsInSentence(String sentence) {
        String[] splitString = sentence.split(" ");
        String s = "";
        for (int i = splitString.length - 1; i >= 0; i--) {
            if (i == 0) s+= splitString[i];
            s+= splitString[i] +" ";
        }
        return s;
    }
}

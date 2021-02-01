package com.himashi.algorithm.reversersentence;

public class ReverseSentenceCharArray {

    public static void main(String[] args) {
        String sentence = "Hello World .";
        char[] sentenceArray = getCharArray(sentence);
        System.out.println(sentenceArray);
        reverseSentence(sentenceArray);
        System.out.println(sentenceArray);
    }

    private static void reverseString (char[] stringArray, int start, int end){
        if (stringArray == null || stringArray.length<2) return;

        while (start<end) {
            char temp = stringArray[start];
            stringArray[start] = stringArray[end];
            stringArray[end] = temp;
            start++;
            end--;
        }
    }

    private static void reverseSentence(char[] sentenceArray) {
        if (sentenceArray == null || sentenceArray.length == 0) return;

        reverseString(sentenceArray, 0, sentenceArray.length-1);

        int start = 0;
        int end;

        while (start < sentenceArray.length) {

            end = start;
            while (end < sentenceArray.length && sentenceArray[end] != ' ' ) {
                ++end;
            }

            reverseString(sentenceArray, start, end-1);
            start = end + 1;
        }




    }

    private static char[] getCharArray(String sentence) {
        char[] sentenceArray = new char[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) {
            sentenceArray[i] = sentence.charAt(i);
        }
        return sentenceArray;
    }
}

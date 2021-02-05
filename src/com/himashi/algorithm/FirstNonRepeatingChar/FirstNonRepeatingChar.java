package com.himashi.algorithm.FirstNonRepeatingChar;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstNonRepeatingChar {

    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating
       then returns -1 */
    static Map<Character, Integer> characterCountMap = new TreeMap<>();
    static char firstNonRepeating(String str)
    {
       char nonRepeatingCharacter = '-';
       if (str == null || str.length() == 0)
           return nonRepeatingCharacter;

       if (str.length() == 1)
           return str.charAt(0);

        for (int i = 0; i< str.length(); i++){
            if (characterCountMap.containsKey(str.charAt(i)))
                characterCountMap.put(str.charAt(i), characterCountMap.get(str.charAt(i))+1);
            else {
                characterCountMap.put(str.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: characterCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                nonRepeatingCharacter = entry.getKey();
                break;
            }
        }
        return nonRepeatingCharacter;
    }

    // Driver method
    public static void main(String[] args)
    {
//        String str = "geeksforgeeks";
        String str = "aaabcccdeeef";
        char uniqueCharacter = firstNonRepeating(str);

        System.out.println(
                uniqueCharacter == '-'
                        ? "Either all characters are repeating or string "
                        + "is empty"
                        : "First non-repeating character is "
                        + uniqueCharacter);
    }
}

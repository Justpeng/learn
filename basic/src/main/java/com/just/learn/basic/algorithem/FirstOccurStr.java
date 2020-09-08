package com.just.learn.basic.algorithem;

import java.util.HashMap;
import java.util.Map;

public class FirstOccurStr {
    public static void main(String[] args) {
        String test = "getMaxOccurChar";
        try {
            char max = getMaxOccurChar(test);
            System.out.println(max);
        } catch (RuntimeException e) {

        }
    }


    public static char getMaxOccurChar(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("非法字符");
        }
        str = str.replace(" ", "");
        Map<Character, Integer> map = new HashMap();
        int maxOccurCount = 0;
        Character firstOccurCharacter = null;
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (map.containsKey(character)) {
                Integer count = map.get(character);
                map.put(character, ++count);
            } else {
                map.put(character, 1);
            }
            Integer currentMax = map.get(character);
            if (currentMax > maxOccurCount) {
                firstOccurCharacter = character;
                maxOccurCount = currentMax;
            } else if (currentMax == maxOccurCount) {
                if (firstOccurCharacter != character) {
                    int charAtKey = str.indexOf(firstOccurCharacter);
                    int characterIndex = str.indexOf(character);
                    if (characterIndex < charAtKey) {
                        firstOccurCharacter = character;
                    }
                    maxOccurCount = currentMax;
                }
            }
        }
        return firstOccurCharacter;
    }

}

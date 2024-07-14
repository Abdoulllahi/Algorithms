package algos.blind75.slidingWindow.characterReplacement;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int maxCount = 0;
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, freqMap.get(rightChar));

            while (right - left - maxCount + 1 > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}


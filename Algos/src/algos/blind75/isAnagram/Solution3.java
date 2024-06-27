package algos.blind75.isAnagram;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapCounter = new HashMap<>();

        for (char c : s.toCharArray()) {
            mapCounter.put(c, mapCounter.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!mapCounter.containsKey(c) || mapCounter.get(c) == 0) return false;
            mapCounter.put(c, mapCounter.get(c) - 1);
        }

        for (int c : mapCounter.values()) {
            if (c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        String s1 = "racecar";
        String t1 = "carrace";
        String s2 = "jar";
        String t2 = "jam";

        System.out.println(solution.isAnagram(s1, t1));  // Output: true
        System.out.println(solution.isAnagram(s2, t2));  // Output: false
    }
}

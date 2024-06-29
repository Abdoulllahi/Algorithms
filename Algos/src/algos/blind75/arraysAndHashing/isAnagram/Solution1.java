package algos.blind75.arraysAndHashing.isAnagram;

import java.util.Arrays;

public class Solution1 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        String s1 = "racecar";
        String t1 = "carrace";
        String s2 = "jar";
        String t2 = "jam";

        System.out.println(solution.isAnagram(s1, t1));  // Output: true
        System.out.println(solution.isAnagram(s2, t2));  // Output: false
    }
}

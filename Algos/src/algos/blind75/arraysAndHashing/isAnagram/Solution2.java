package algos.blind75.arraysAndHashing.isAnagram;

public class Solution2 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String s1 = "racecar";
        String t1 = "carrace";
        String s2 = "jar";
        String t2 = "jam";

        System.out.println(solution.isAnagram(s1, t1));
        System.out.println(solution.isAnagram(s2, t2));
    }
}

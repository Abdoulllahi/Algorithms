package algos.leetcode75.two_pointers;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        
        if (s.isEmpty()) {
            return true; // An empty string is always a subsequence
        }
        int subIndex = 0;
        for (var c : t.toCharArray()) {
            if (c == s.charAt(subIndex)) {
                subIndex++;
            }
            if (subIndex == s.length()) {
                break;
            }
        }
        return subIndex == s.length();
    }
}

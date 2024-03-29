package algos.leetcode75.sliding_window;

public class MaxVowels {

    public int maxVowels(String s, int k) {

        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) count++;
        }

        maxCount = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) count--;
            if (isVowel(s.charAt(i))) count++;
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }
}

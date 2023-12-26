package algos.leetcode75.array_string;

public class ReverseVowels {

    public String reverseVowels(String s) {

        char[] letters = s.toCharArray();
        int start = 0;
        int end = letters.length - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            while (start < end && vowels.indexOf(letters[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(letters[end]) == -1) {
                end--;
            }
            if (start < end) {
                char temp = letters[start];
                letters[start] = letters[end];
                letters[end] = temp;
                start++;
                end--;
            }
        }

        return new String(letters);
    }
}

package algos.leetcode75.array_string;

public class MergeStringAlternately {
    
    public String mergeAlternately(String word1, String word2) {
        
        int length1 = word1.length();
        int length2 = word2.length();
        int minLength = Math.min(length1, length2);
        StringBuilder finalWord = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            finalWord.append(word1.charAt(i)).append(word2.charAt(i));
        }

        for (int i = minLength; i < length1; i++) {
            finalWord.append(word1.charAt(i));
        }

        for (int i = minLength; i < length2; i++) {
            finalWord.append(word2.charAt(i));
        }

        return finalWord.toString();
    }
}

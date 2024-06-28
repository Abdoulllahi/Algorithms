package algos.blind75.groupAnagram;

import java.util.*;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for (String word : strs) {
            char[] charWord = word.toCharArray();
            Arrays.sort(charWord);
            String sortedWord = new String(charWord);

            if (!res.containsKey(sortedWord)){
                res.put(sortedWord, new ArrayList<>());
            }

            res.get(sortedWord).add(word);
        }

        return new ArrayList<>(res.values());
    }
}

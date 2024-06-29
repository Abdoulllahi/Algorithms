package algos.blind75.arraysAndHashing.stringEncodeAndDecode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append('@').append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String encodedString) {
        List<String> strs = new ArrayList<>();

        int i = 0;
        while (i < encodedString.length()) {
            int j = i;
            while (encodedString.charAt(j) == '@')
                j++;
            int len = Integer.parseInt(encodedString.substring(i, j));
            i = j + 1 + len;
            strs.add(encodedString.substring(j + 1, i));
        }

        return strs;
    }
}

package algos.leetcode75.array_string;

import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
     public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    
        int max = 0;
        int len = candies.length;
        Boolean[] result = new Boolean[len];

        for (int i = 0; i < len; i++) {
            int candy = candies[i];
            max = candy > max ? candy : max;
        }

        for (int i = 0; i < len; i++) {
            result[i] = candies[i] + extraCandies >= max ? true : false; 
        }
        return Arrays.asList(result);
    }
}

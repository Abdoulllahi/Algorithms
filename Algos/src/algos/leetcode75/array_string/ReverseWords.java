package algos.leetcode75.array_string;

public class ReverseWords {
    
    public String reverseWords(String s) {
        
        String[] myList = s.split("\\s+");
        int left = 0;
        int right = myList.length - 1;
        
        while(left <= right) {
            String temp = myList[left];
            myList[left] = myList[right];
            myList[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", myList).trim();
    }
}

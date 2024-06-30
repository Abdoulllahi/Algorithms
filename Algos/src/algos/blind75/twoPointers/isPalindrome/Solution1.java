package algos.blind75.twoPointers.isPalindrome;

class Solution1 {
    public boolean isPalindrome(String s) {

        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                str.append(Character.toLowerCase(c));
        }

        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}


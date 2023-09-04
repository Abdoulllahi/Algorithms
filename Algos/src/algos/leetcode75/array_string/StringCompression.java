package algos.leetcode75.array_string;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(
                compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd' }));

    }

    public static int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                sb.append(chars[i]);
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }

        // Handle the last character after the loop
        sb.append(chars[chars.length - 1]);
        if (count > 1) {
            sb.append(count);
        }

        // Copy the compressed string back to the chars array
        String compressed = sb.toString();
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }

        return compressed.length();
    }
}


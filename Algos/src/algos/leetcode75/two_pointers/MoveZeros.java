package algos.leetcode75.two_pointers;

public class MoveZeros {

    public void moveZeros(int[] num) {
        int i = 0;
        for (int j = 0; j < num.length; j++) {
            if (num[j] != 0) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                i++;
            }
        }
    }
}

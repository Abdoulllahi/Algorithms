package algos.leetcode75.array_string;

public class CanPlaceFlowers {
    
     public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int len = flowerbed.length;
        int [] extendedFlowerbed = new int[len + 2];
        System.arraycopy(flowerbed, 0, extendedFlowerbed, 1, len);

        for (int i = 1; i <= len; i++) {
            if (extendedFlowerbed[i] == 0 && extendedFlowerbed[i - 1] == 0 && extendedFlowerbed[i + 1] == 0) {
                extendedFlowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}

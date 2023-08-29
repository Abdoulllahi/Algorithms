
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;

import java.util.Set;

import DS.implementations.QueueArray;
import DS.interfaces.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(gcd(48, 36));
        // System.out.println(Arrays.toString(merge(new int[] {1, 4, 5, 8, 17}, new int[] {2, 4, 8, 11, 13, 21, 23, 25})));
        // System.out.println(mc91(56));
        // 325641
        // Stack stack1 = new StackArray(6);
        // stack1.push(1);
        // stack1.push(2);
        // stack1.push(3);
        // stack1.pop();
        // stack1.pop();
        // stack1.push(4);
        // stack1.push(5);
        // stack1.pop();
        // stack1.push(6);
        // stack1.pop();
        // stack1.pop();
        // stack1.pop();

        //154623
        // Stack stack2 = new StackArray(6);
        // stack2.push(1);
        // stack2.pop();
        // stack2.push(2);
        // stack2.push(3);
        // stack2.push(4);
        // stack2.push(5);
        // stack2.pop(); //5
        // stack2.pop(); //4
        // stack2.push(6);
        // stack2.pop(); //6
        // //cannot have 2 as ouput before 3
        // stack2.pop(); //3
        // stack2.pop(); //3
        Queue queue = new QueueArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        queue.enqueue(1);
        System.out.println(queue);
    }

    public static int gcd(int m, int n) {
        m = Math.abs(m);
        n = Math.abs(n);
        while (n != 0) {
            int remainder = m % n;
            m = n;
            n = remainder;
        }

        return m;
        // int smaller = m > n ? n : m;
        // int gcd = 1;
        // for (int i = 2; i <= smaller; i++) {
        //     if (m % i == 0 && n % i == 0) {
        //         gcd = i;
        //     }
        // }
        // return gcd;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] sorted = new int[length1 + length2];
        while (i < length1 && j < length2) {
            if (arr1[i] < arr2[j]) {
                sorted[k++] = arr1[i++];
            } else {
                sorted[k++] = arr2[j++];
            }
        }
        // Ensure that all lists are empty:
        while (i < length1) {
            sorted[k++] = arr1[i++];
        }
        while (j < length2) {
            sorted[k++] = arr2[j++];
        }
        return sorted;
    }

    int[] arrays(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                arr[i] += arr[j] + i + j;
            }
        }
        return arr;
    }

    public static List<Set<Integer>> powerSet(List<Integer> X) {
        List<Set<Integer>> P = new ArrayList<>();
        Set<Integer> S = new HashSet<>();
        P.add(S);

        while (!X.isEmpty()) {
            int f = X.remove(0);
            List<Set<Integer>> temp = new ArrayList<>();

            for (Set<Integer> x : P) {
                Set<Integer> T = new HashSet<>(x);
                T.add(f);
                temp.add(T);
            }

            P.addAll(temp);
        }

        return P;
    }

    public static int mc91(int n) {
        if (n > 100) {
            return n - 10;
        }
        return mc91(mc91(n + 11));
    }
}

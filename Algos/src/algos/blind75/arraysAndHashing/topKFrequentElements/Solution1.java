package algos.blind75.arraysAndHashing.topKFrequentElements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mapCounter = new HashMap<>();
        for (int num : nums) {
            mapCounter.put(num, mapCounter.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : mapCounter.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] res = new int[k];
        int i = 0;

        while(!minHeap.isEmpty()) {
            res[i++] = minHeap.poll().getKey();
        }

        return res;
    }
}


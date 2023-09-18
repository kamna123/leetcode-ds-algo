class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         if (nums.length == k) return nums;
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(heap.size() > 0) {
            res[index++] = heap.poll();
        }
        return res;
    }
}
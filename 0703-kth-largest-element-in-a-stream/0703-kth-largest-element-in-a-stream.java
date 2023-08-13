class KthLargest {
    private PriorityQueue<Integer> queue;
    private static int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>((a, b) -> a - b);
        for (int val : nums) {
            queue.offer(val);

        }
        while (queue.size() > k) {
            queue.poll();
        } 
    }
    
    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
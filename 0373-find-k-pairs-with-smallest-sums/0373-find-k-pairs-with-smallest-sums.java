class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        minHeap.offer(new int[] { nums1[0] + nums2[0], 0, 0 });
        visited.add(new Pair<Integer, Integer>(0, 0));

        while (k > 0 && !minHeap.isEmpty()) {
            int top[] = minHeap.poll();
            ans.add(Arrays.asList(nums1[top[1]], nums2[top[2]]));

            if (top[1] + 1 < nums1.length && !visited.contains(new Pair<Integer, Integer>(top[1] + 1, top[2]))) {
                minHeap.offer(new int[] { nums1[top[1] + 1]+ nums2[top[2]], top[1] + 1, top[2] });
                visited.add(new Pair<Integer, Integer>(top[1] + 1,top[2]));
            }
            if (top[2] + 1 < nums2.length && !visited.contains(new Pair<Integer, Integer>(top[1], top[2] + 1))) {
                minHeap.offer(new int[] { nums1[top[1]]+ nums2[top[2] + 1], top[1] , top[2] + 1});
                visited.add(new Pair<Integer, Integer>(top[1],top[2] + 1));
            }
            k--;
        }
        return ans;
    }
}
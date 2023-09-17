class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] top = stack.peek();
            if (curr[0] <= top[1]) {
                top[1] = Math.max(top[1], curr[1]);
            } else {
                stack.push(curr);
            }
        }
        int[][] res = new int[stack.size()][2];
        int index = 0;
        while(!stack.empty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
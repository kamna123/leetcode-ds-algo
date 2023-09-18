class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int dp[][] = new int[nums.length][totalSum / 2 + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(nums, totalSum / 2,0,  dp);
    }

    public boolean dfs(int[] nums, int sum, int index, int[][] dp) {
        if (sum == 0)
            return true;
        if (index >= nums.length || sum < 0)
            return false;
        if (dp[index][sum] != -1) {
            if(dp[index][sum] == 1) return true;
            return false;
        }
        boolean res = dfs(nums, sum - nums[index], index + 1, dp) || dfs(nums, sum, index + 1, dp);
        if (res) {
            dp[index][sum] = 1;
        } else {
            dp[index][sum] = 0;
        }
        return res;
    }
}
class Solution {
    public int robHelper(int[] nums, int index, int len, int[] memo) {
        if (index >= len)
            return 0;
        if (memo[index] != -1) return memo[index];
        int res = Math.max(robHelper(nums, index + 1, len, memo), robHelper(nums, index + 2, len, memo) + nums[index]);
        memo[index] = res;
        return res;

    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int takeFirstHome = robHelper(nums, 0, nums.length - 1, memo);
        Arrays.fill(memo, -1);
        int dontTakeFirstHome = robHelper(nums, 1, nums.length, memo);
        return Math.max(takeFirstHome, dontTakeFirstHome);

    }
}
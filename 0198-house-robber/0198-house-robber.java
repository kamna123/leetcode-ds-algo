class Solution {
    public int robHelper(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        int res = Math.max(robHelper(nums, index + 1, memo), robHelper(nums, index + 2, memo) + nums[index]);
        memo[index] = res;
        return res;
        
    }
    public int rob(int[] nums) {
       int[] memo = new int[nums.length];
       Arrays.fill(memo, -1); 
       return robHelper(nums, 0, memo);
    }
}
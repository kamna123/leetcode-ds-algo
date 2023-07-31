class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) return nums[left];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            // first part is sorted
            if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
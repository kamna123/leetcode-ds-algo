class Solution {

        
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int i, int j) {
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1])
            index--;
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        int k = len - 1;
        while(k >= 0 && nums[k] <= nums[index]) k--;
        swap(nums, k, index);
        reverse(nums, index + 1, len - 1);


    }
    
}
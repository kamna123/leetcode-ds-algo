class Solution {
    public void subsetsHelper(int[] nums, int index, List<Integer> curr, List<List<Integer>>  res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        subsetsHelper(nums, index + 1, curr, res);
        curr.add(nums[index]);
        subsetsHelper(nums, index + 1, curr, res);
        curr.remove(curr.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
}
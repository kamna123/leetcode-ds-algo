class Solution {
     public void util (int[] nums, List<Integer> curr,  List<List<Integer>> res, Set<Integer> set) {
        if (set.size() >= nums.length) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
          //  System.out.println("i == " +i);
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            curr.add(nums[i]);
            util(nums, curr, res, set);
            set.remove(nums[i]);
            curr.remove(curr.size() - 1);
        }
       
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        util(nums, new ArrayList<Integer>(), res, new HashSet<Integer>());
        return res;
    }
}
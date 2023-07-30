class Solution {
    public void combinationSumUtil(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int currIndex) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = currIndex; i < candidates.length; i++) {
            curr.add(candidates[i]);
            combinationSumUtil(candidates, target - candidates[i], res, curr, i);
            curr.remove(curr.size() - 1);
        }


    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumUtil(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
}
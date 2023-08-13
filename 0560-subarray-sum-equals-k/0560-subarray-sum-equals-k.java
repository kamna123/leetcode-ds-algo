class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); 

        int res = 0;    
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                res++;
            } 
            if (map.containsKey(prefixSum - k)) {
                res += map.get(prefixSum- k);
            }
         
             map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;    
  }  
}
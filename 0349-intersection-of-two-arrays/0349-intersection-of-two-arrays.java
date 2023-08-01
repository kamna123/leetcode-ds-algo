class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num))
                res.add(num);
        }
        int[] output = new int[res.size()];
        int index = 0;
        for (int r : res) {
            output[index++] = r;
        } 
        return output;
    }
}
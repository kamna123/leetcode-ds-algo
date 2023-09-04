class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> pos = new HashMap<>();
        while (end < s.length()) {
            if (pos.containsKey(s.charAt(end))) {
                start = Math.max(start, pos.get(s.charAt(end)) + 1);
            }
            pos.put(s.charAt(end), end);
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
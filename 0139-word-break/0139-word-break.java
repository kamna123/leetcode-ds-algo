class Solution {
    public boolean wordBreakHelper(String s, HashSet<String> set, int index, int[] memo) {
        if (index == s.length()) {
            return true;
        }
        if (memo[index] != -1) {
            return memo[index] == 1 ? true : false;
        }
        boolean res = false;
        for (int i = index; i < s.length(); i++) {
            String subString = s.substring(index, i + 1);
            if (set.contains(subString) && wordBreakHelper(s, set, i + 1, memo)) {
                res = true;
            }
        }
        if (res == true) {
            memo[index] = 1;
        } else {
            memo[index] = 0;
        }

        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return wordBreakHelper(s, set, 0, memo);
    }
}
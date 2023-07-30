class Solution {
    public int uniquePathHelper(int m, int n, int currM, int currN, int[][] dp) {
        if (currM == m - 1 && currN == n - 1) {
            return 1;
        }
        if (currM >= m || currN >= n)
            return 0;
        if (dp[currM][currN] != -1) return dp[currM][currN];
        int res = uniquePathHelper(m, n, currM + 1, currN, dp) + uniquePathHelper(m, n, currM, currN + 1, dp);
        dp[currM][currN] = res;
        return res;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] memo : dp) {
            Arrays.fill(memo, -1);
        }
        return uniquePathHelper(m, n, 0, 0, dp);
    }
}
class Solution {
    final int INF = Integer.MAX_VALUE / 2;

    public int coinChangeHelper(int[] coins, int amount, int index, int[][] memo) {
        if (index >= coins.length) {
            if (amount == 0) {
                return 0;
            }
            return INF;
        }
        if (amount < 0) {
            return INF;
        }
        if (memo[amount][index] != -1) return memo[amount][index];
        int res = INF;
        int takeCoin = 1 + coinChangeHelper(coins, amount - coins[index], index, memo);
        // System.out.println("takecoing "+ takeCoin);
        res = Math.min(res, takeCoin);
        int dontTakeCoin = coinChangeHelper(coins, amount, index + 1, memo);
        // System.out.println("dont "+ dontTakeCoin);
        res = Math.min(res, dontTakeCoin);
        memo[amount][index] = res;
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[amount + 1][coins.length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int res = coinChangeHelper(coins, amount, 0, memo);
        return res >= INF ? -1 : res;
    }
}
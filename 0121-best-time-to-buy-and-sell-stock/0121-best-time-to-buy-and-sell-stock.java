class Solution {
    public int maxProfit(int[] prices) {
        int[] buyMin = new int[prices.length];
        buyMin[0] = prices[0];
        int sellMax = prices[prices.length - 1];
        int profit = sellMax - buyMin[0];
        for (int i = 1; i < prices.length; i++) {
            buyMin[i] = Math.min(buyMin[i-1], prices[i]);
            // System.out.println("buyMin " + buyMin[i]);
        }
        for (int i = prices.length - 1; i >= 0; i--) {
            sellMax = Math.max(sellMax, prices[i]);
            //System.out.println("i -- " + i + " sellMax - "+sellMax + " buyMin -" +buyMin[i] );
            profit = Math.max(profit, sellMax - buyMin[i]);
        }
        return profit;
    }
}
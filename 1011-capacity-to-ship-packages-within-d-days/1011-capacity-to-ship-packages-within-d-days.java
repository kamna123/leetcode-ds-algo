class Solution {
    public boolean isFeasible(int[] weights, int currWeight, int days) {
        int daysNeeded = 1;
        int currLoad = 0;
        for (int w : weights) {
            currLoad += w;
            if (currLoad > currWeight) {

                daysNeeded++;
                currLoad = w;
                if (daysNeeded > days)
                    return false;
            }

        }
        return daysNeeded <= days;

    }

    public int shipWithinDays(int[] weights, int days) {
        int res = 0;
        int totalLoad = 0;
        int maxLoad = 0;
        for (int w : weights) {
            totalLoad += w;
            maxLoad = Math.max(w, maxLoad);
        }

        int l = maxLoad, r = totalLoad;
        while (l <= r) {
            int mid = (l + r) / 2;
            boolean res1 = isFeasible(weights, mid, days);
            System.out.println("left " + l + " right "+ r + " mid "+mid + " res "+ res1);
            if (res1) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
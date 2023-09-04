class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;
        int availableNum = 9;
        int prevCount = 9;
        while(n > 1) {
            prevCount = prevCount * availableNum;
            availableNum--;
            res += prevCount;
            n--;
        }
        return res;
    }
}
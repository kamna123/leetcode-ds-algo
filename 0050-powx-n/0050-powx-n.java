class Solution {
    public double myPowHelper(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1.0 / myPowHelper(x, -1 * n);
        }    
        double res = myPowHelper(x, n / 2);
        if (n % 2 == 1) {
            return res * res * x;
        } else {
            return res * res;
        }
    }
    public double myPow(double x, int n) {
        return myPowHelper(x, (long) n);
    }
}
/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return ans;
    }
}


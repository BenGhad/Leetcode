class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        long next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            long nextUgly = Math.min(next2, Math.min(next3, next5));
            dp[i] = (int) nextUgly;
            if (nextUgly == next2) {
                i2++;
                next2 = (long) dp[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = (long) dp[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = (long) dp[i5] * 5;
            }
        }

        return dp[n - 1];
    }
}

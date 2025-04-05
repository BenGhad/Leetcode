class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int num1 = nums1[i - 1];
                int num2 = nums2[j - 1];
                
                int prev1 = dp[i - 1][j];
                int prev2 = dp[i][j - 1];
                int prevBoth = dp[i - 1][j - 1];

                int maxPrev = Math.max(prev1, Math.max(prev2, prevBoth));

                if(num1 == num2){
                    dp[i][j] = prevBoth + 1;
                } else {
                    dp[i][j] = maxPrev;
                }
            }
        }

        return dp[n][m];

    }
}

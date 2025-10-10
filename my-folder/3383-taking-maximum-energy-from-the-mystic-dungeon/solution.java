class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = Arrays.copyOf(energy, n);
        int max = Integer.MIN_VALUE;

        for(int i = n - 1; i >= k; i--){
            dp[i - k] += dp[i];
        }

        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

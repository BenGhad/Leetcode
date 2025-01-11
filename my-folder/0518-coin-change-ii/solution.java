class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = coins[0]; i < dp.length; i+= coins[0]){
            dp[i] = 1;
        }

        for(int j = 1; j < coins.length; j++){
            int coin = coins[j];
            for(int i = 0; i < dp.length; i++){
                if(dp[i] != 0 && i + coin < dp.length){
                    dp[i + coin] += dp[i];
                }
            }
        }

        return dp[amount];
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int biggy = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            biggy = Math.max(biggy, nums[i]);
        }
        if(sum % 2 != 0) return false;
        if(biggy > sum / 2) return false;

        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        dp[0][0] = true;
        for(int i = 0; i < dp.length - 1; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j]){
                    int num = nums[i];
                    if(j + num <= sum / 2){
                        dp[i + 1][j + num] = true;
                    }
                    dp[i + 1][Math.abs(j - num)] = true;
                }
            }
        }

        return dp[nums.length][0];
    }
}

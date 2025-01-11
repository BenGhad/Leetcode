class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = n;
        }
        dp[0] = 0;

        List<Integer> squares = new ArrayList<>();
        for(int j = 1; j * j <= n; j++){
            squares.add(j * j);
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int s : squares){
                if(i >= s){
                    dp[i] = Math.min(dp[i], dp[i - s] + 1);
                } else {
                    break;
                }
            }
        }
        
        return dp[n];
    }
}

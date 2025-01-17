class Solution {
    int mod = 1000000007;
    public int knightDialer(int n) {
        int[][] adj = {
            {4, 6},     // 0
            {6, 8},     // 1
            {7, 9},     // 2
            {4, 8},     // 3
            {0, 3, 9},  // 4
            {},         // 5
            {0, 1, 7},  // 6
            {2, 6},     // 7
            {1, 3},     // 8
            {2, 4}      // 9
        };
        
        int[][] dp = new int[n + 1][10];
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 10; j++){
                for(int neighbor : adj[j]){
                    dp[i][j] = (dp[i][j] + dp[i - 1][neighbor]) % mod;
                }
            }
            
        }
        
        int ans = 0;
        for(int i = 0; i < 10; i++){
            ans = (ans + dp[n][i]) % mod;
        }
        return ans;
        
        
    }
}

/*
adj[0] = new int[]{4, 6};
        adj[1] = new int[]{6, 8};
        adj[2] = new int[]{7, 9};
        adj[3] = new int[]{4, 8};
        adj[4] = new int[]{3, 9, 0};
        adj[5] = new int[0];
        adj[6] = new int[]{1, 7, 0};
        adj[7] = new int[]{2, 6};
        adj[8] = new int[]{1, 3};
        adj[9] = new int[]{2, 4};
        */

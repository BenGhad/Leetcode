class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            dp[i][n - 1] = 0;
        }

        for(int col = n - 2; col >= 0; col--){
            for(int row = 0; row < m; row++){
                int griddy = grid[row][col];
                if(griddy < grid[row][col + 1]){
                    dp[row][col] = Math.max(dp[row][col], dp[row][col + 1] + 1);
                }
                if(row > 0 && griddy < grid[row - 1][col + 1]){
                    dp[row][col] = Math.max(dp[row][col], dp[row - 1][col +1] + 1);
                }
                if(row < m - 1 && griddy < grid[row + 1][col + 1]){
                    dp[row][col] = Math.max(dp[row][col], dp[row + 1][col + 1] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < dp.length; i++){
            max = Math.max(dp[i][0], max);
        }
        return max;

    }
}

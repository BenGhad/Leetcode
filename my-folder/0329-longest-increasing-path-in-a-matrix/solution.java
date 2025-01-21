class Solution {
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length; // ie which row
        int n = matrix[0].length; // ie which col
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath(i, j, matrix);
            }
        }

        int max = 0;
        for (int[] row : dp) {
            for (int cell : row) {
                max = Math.max(max, cell);
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        return max;
    }

    public void longestPath(int i, int j, int[][] matrix) {
        int[][] direction = new int[][] {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        for (int[] dir : direction) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= dp.length || y < 0 || y >= dp[0].length)
                continue;
            if (matrix[x][y] > matrix[i][j]) {
                if (dp[x][y] == 0)
                    longestPath(x, y, matrix);
                dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
            }
        }
        if (dp[i][j] == 0)
            dp[i][j] = 1;
    }
}

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        int[][] directions = new int[][] {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] { 0, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int t = cur[0];
            int x = cur[1];
            int y = cur[2];
            
            if(t > dp[x][y]) continue;
            if(x == n - 1 && y == m - 1) return t;
            
            for(int[] d : directions){
                int dx = x + d[0];
                int dy = y + d[1];
                if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;

                int time = Math.max(t, moveTime[dx][dy]);
                if(time + 1 < dp[dx][dy]){
                    dp[dx][dy] = time + 1;
                    queue.offer(new int[]{time + 1, dx, dy});
                }
            }

        }

        return dp[n - 1][m - 1];
    }
}

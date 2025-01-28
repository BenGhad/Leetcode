class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] > 0){
                    max = Math.max(max, goFish(grid, new int[]{i, j}));
                }
            }
        }
        return max;
    }

    public int goFish(int[][] grid, int[] pos){
        int fish = grid[pos[0]][pos[1]];
        grid[pos[0]][pos[1]] = 0;
        int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(pos);
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[] dir : directions){
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if(x < 0 || y < 0 || x == grid.length || y == grid[0].length) continue;
                if(grid[x][y] > 0){
                    fish += grid[x][y];
                    grid[x][y] = 0;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return fish;
    }
}

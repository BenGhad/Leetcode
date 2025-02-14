class NeighborSum {
    int[][] map;
    int[][] grid;
    public NeighborSum(int[][] grid) {
        int n = grid.length;
        this.grid = grid;
        map = new int[n * n][2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                map[grid[i][j]] = new int[]{i, j};
            }
        }
    }
    
    public int adjacentSum(int value) {
        int[] coord = map[value];
        int x = coord[0];
        int y = coord[1];
        int sum = 0;
        if(x > 0) sum += grid[x - 1][y];
        if(x < grid.length - 1) sum += grid[x + 1][y];
        if(y > 0) sum += grid[x][y - 1];
        if(y < grid[0].length - 1) sum += grid[x][y + 1];
        return sum;
    }
    
    public int diagonalSum(int value) {
        int[] coord = map[value];
        int x = coord[0];
        int y = coord[1];
        int sum = 0;
        if(x > 0 && y > 0) sum += grid[x - 1][y - 1];
        if(x > 0 && y < grid[0].length - 1) sum += grid[x - 1][y + 1];
        if(x < grid[0].length - 1 && y < grid[0].length - 1) sum += grid[x + 1][y + 1];
        if(x < grid[0].length - 1 && y > 0) sum += grid[x + 1][y - 1];
        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */

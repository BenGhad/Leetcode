class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int unreachables = 0;
        for(int i = 0; i < grid[0].length; i++){
            //grid[0][i]
                if(grid[0][i] == 1 && !visited[0][i]){
                    traverse(grid, visited, 0, i);
                }
            //grid[grid.length - 1][i]
                if(grid[grid.length - 1][i] == 1 && !visited[grid.length - 1][i]){
                    traverse(grid, visited, grid.length - 1, i);
                }
        }

        for(int j = 0; j < grid.length; j++){
            //grid[j][0]
                if(grid[j][0] == 1 && !visited[j][0]){
                    traverse(grid, visited, j, 0);                    
                }
            //grid[j][grid[0].length - 1]
                if(grid[j][grid[0].length - 1] == 1 && !visited[j][grid[0].length - 1]){
                    traverse(grid, visited, j, grid[0].length - 1);
                }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    unreachables++;
                }
            }
        }
        return unreachables;        
    }


    public void traverse(int[][] grid, boolean[][] visited, int row, int col) {
        // Boundary check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;

        // Move Right
        traverse(grid, visited, row, col + 1);
        // Move Left
        traverse(grid, visited, row, col - 1);
        // Move Down
        traverse(grid, visited, row + 1, col);
        // Move Up
        traverse(grid, visited, row - 1, col);
    }

}

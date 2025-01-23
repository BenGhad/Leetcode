class Solution {
    public int countServers(int[][] grid) {
        int servers = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    connected(i, j, grid);
                } 
                if (grid[i][j] == 2){
                    servers++; //Processed, it's visited
                }
            }
        }
        return servers;
    }

    // Checks rows, if another server, mark it as 2, same for cols
    public void connected(int i, int j, int[][] grid){
        //rows:
        for(int idx = 0; idx < grid[0].length; idx++){
            if(idx == j) continue;
            if(grid[i][idx] >= 1){
                grid[i][idx] = 2;
                grid[i][j] = 2;
            }    
        }
        //Cols:
        for(int idx = 0; idx < grid.length; idx++){
            if(idx == i) continue;
            if(grid[idx][j] >= 1){
                grid[idx][j] = 2;
                grid[i][j] = 2;
            }
        }
    } 
}

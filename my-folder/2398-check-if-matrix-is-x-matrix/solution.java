class Solution {
    public boolean checkXMatrix(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(((i == j) | (i == grid.length - 1 - j)) && grid[i][j] == 0){
                    return false;
                } 
                if(grid[i][j] != 0 && i != j && i != grid.length - 1 - j) {
                    return false;
                }
            }   
        }
        return true;
    }
}

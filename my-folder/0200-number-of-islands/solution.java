class Solution {
    char[][] grid;
    int n;
    int m;
    public int numIslands(char[][] g) {
        grid = g;
        n = g.length;
        m = g[0].length;

        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(i, j);
                }
            }
        }
        return ans;
    }

    void dfs(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m) return;
        if(grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
}

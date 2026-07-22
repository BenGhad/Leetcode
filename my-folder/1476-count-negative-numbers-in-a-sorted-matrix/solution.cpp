class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        int ans = 0;
        
        // iter over rows
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] < 0){
                    // col J..m is diddy
                    ans += m-j;
                    break;
                }
            }
        }
        return ans;
    }
};

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] visited = new int[m][n];
        //0 = occupied, 1 = wall, 2 = seen
        int r = m * n - guards.length - walls.length;

        //Add walls
        for(int[] wall : walls){
            visited[wall[0]][wall[1]] = 1;
        }
        for(int[] guard : guards){
            visited[guard[0]][guard[1]] = 1;
        }
        
        //Add guards:
        for(int[] guard : guards){
            int row = guard[0]; 
            int col = guard[1];

          // Down
            for (int i = row + 1; i < m; i++) {
                if (visited[i][col] == 1) break; // Stop at wall or guard
                if (visited[i][col] == 0) {
                    visited[i][col] = 2;
                    r--;
                }
            }
            // Up
            for (int i = row - 1; i >= 0; i--) {
                if (visited[i][col] == 1) break;
                if (visited[i][col] == 0) {
                    visited[i][col] = 2;
                    r--;
                }
            }
            // Right
            for (int j = col + 1; j < n; j++) {
                if (visited[row][j] == 1) break;
                if (visited[row][j] == 0) {
                    visited[row][j] = 2;
                    r--;
                }
            }
            // Left
            for (int j = col - 1; j >= 0; j--) {
                if (visited[row][j] == 1) break;
                if (visited[row][j] == 0) {
                    visited[row][j] = 2;
                    r--;
                }
            }
        }

        return r;
    }
}

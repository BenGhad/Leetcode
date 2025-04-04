class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        int dummyIndex = m * n; // dummy node index
        DSU dsu = new DSU(m * n + 1);
        int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // 1. Union border 'O's with dummy node.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dsu.union(index(i, j, board), dummyIndex);
                }
            }
        }

        // 2. Union interior 'O's with adjacent 'O's.
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(board[i][j] == 'O'){
                    for(int[] dir : directions){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'){
                            dsu.union(index(i, j, board), index(x, y, board));
                        }
                    }
                }
            }
        }

        // 3. Replace 'O's not connected to dummy with 'X'
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                // If this cell is 'O' but not connected to the dummy node, flip it.
                if(board[i][j] == 'O' && dsu.find(index(i, j, board)) != dsu.find(dummyIndex)){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public int index(int i, int j, char[][] board){
        // Use the number of columns for proper indexing.
        return i * board[0].length + j;
    }

    public class DSU {
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]); // path compression
            }
            return parent[i];
        }

        public void union(int i, int j){
            int rootX = find(i);
            int rootY = find(j);
            if(rootX != rootY){
                parent[rootY] = rootX;
            }
        }
    }
}


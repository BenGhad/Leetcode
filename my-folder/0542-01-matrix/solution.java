class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dir = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                
                for(int d[] : dir){
                    int dx = x + d[0];
                    int dy = y + d[1];
                    if(dx < 0 || dy < 0 || dx >= m || dy >= n) continue;
                    
                    if(dist[dx][dy] > dist[x][y] + 1){
                        dist[dx][dy] = dist[x][y] + 1;
                        queue.offer(new int[]{dx, dy});
                    }
                }
                
            }    
        }
        
        return dist;
    }
}

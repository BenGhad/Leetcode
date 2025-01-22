class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    queue.offer(new int[]{i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }

        int[][] direction = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int h = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            h++;
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                height[x][y] = h;
                for(int[] dir : direction){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && height[newX][newY] == -1){
                        queue.offer(new int[]{newX, newY});
                        height[newX][newY] = -2; // do not revisit on same level
                    }
                }
            }
        }
        return height;
    }
}

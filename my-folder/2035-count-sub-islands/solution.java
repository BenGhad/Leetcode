class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int islands = 0;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
Queue<int[]> queue = new ArrayDeque<>();
                    
        // Find Grid2Islands
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) { // ISLAND!
                    grid2[i][j] = 0;
                    boolean sub = true;
                    queue.offer(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        if(grid1[pos[0]][pos[1]] == 0) sub = false;
                        for(int[] dir : directions){
                            int x = pos[0] + dir[0];
                            int y = pos[1] + dir[1];
                            if(x >= 0 && x < grid2.length && y >= 0 && y < grid2[0].length && grid2[x][y] == 1){
                                grid2[x][y] = 0;
                                queue.offer(new int[]{x, y});
                            }
                        }

                    }

                    if (sub)
                        islands++;
                }
            }
        }

        return islands;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int[][] dir = new int[][] {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            if(mat[x][y] != 0) mat[x][y] = Integer.MAX_VALUE; 
            visited[x][y] = true;
            for (int[] d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX < 0 || newY < 0 || newX >= mat.length || newY >= mat[0].length)
                    continue;
                if (visited[newX][newY]) {
                    mat[x][y] = Math.min(mat[x][y], mat[newX][newY] + 1);
                } else {
                    queue.offer(new int[] { newX, newY });
                }
            }

        }
        return mat;

    }
}

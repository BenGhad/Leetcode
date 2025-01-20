class Solution {
    int row, col;

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        row = maze.length;
        col = maze[0].length;

        int level = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                
                if (isExit(x, y) && !(x == entrance[0] && y == entrance[1])) {
                    return level;
                }
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < row && newY >= 0 && newY < col
                            && maze[newX][newY] == '.') {
                        queue.offer(new int[] { newX, newY });
                        maze[newX][newY] = '+';
                    }
                }
            }
        }
        return -1;
    }

    public boolean isExit(int x, int y) {
        return x == 0 || x == row - 1 || y == 0 || y == col - 1;
    }
}

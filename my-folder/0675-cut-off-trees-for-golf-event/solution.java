class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1){
                    list.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        
        
        list.sort((a, b) -> Integer.compare(a[2], b[2]));
        
        int[] pos = {0, 0};
        int ans = 0;
        
        for(int i = 0; i < list.size(); i++){
            int steps = bfs(forest, pos, new int[]{list.get(i)[0], list.get(i)[1]});
            if(steps == -1) return -1;
            ans += steps;
            pos = new int[]{list.get(i)[0], list.get(i)[1]};
        }
        
        
        
        return ans;
    }
    
    
    public int bfs(List<List<Integer>> forest, int[] start, int[] target){
        if(start[0] == target[0] && start[1] == target[1]){
            return 0;
        }
        
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        int steps = 0;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                for(int[] dir : directions){
                    int newRow = pos[0] + dir[0];
                    int newCol = pos[1] + dir[1];
                     
                    if(newRow >=0 && newRow < m && newCol >=0 && newCol < n 
                       && !visited[newRow][newCol] && forest.get(newRow).get(newCol) != 0){
                        if(newRow == target[0] && newCol == target[1]){
                            return steps;
                        }
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    
                    }
                }
            }
        }
        return -1;
    }
}
   

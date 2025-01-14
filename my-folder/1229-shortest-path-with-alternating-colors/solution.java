class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //Construct adj, 0 red, 1 blue
        List<int[]>[] adj = new ArrayList[n]; 
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : redEdges){
            int s = edge[0];
            int d = edge[1];
            adj[s].add(new int[]{d, 0});
        }

        for(int[] edge : blueEdges){
            int s = edge[0];
            int d = edge[1];
            adj[s].add(new int[]{d, 1});
        }

        //Construct visited/ans
        int[] ans = new int[n];
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;
        visited[0][1] = true;
        Arrays.fill(ans, -1);
        
        //BFS
        ans[0] = 0;
        Queue<int[]> queue = new LinkedList<>(); //Node, Total_Cost
        
        queue.offer(new int[]{0, 0, -1});

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int node = tmp[0];
            int path = tmp[1];
            int color = tmp[2];

            for(int[] edge : adj[node]){
                int neighbor = edge[0];
                int c = edge[1];
                if(color == c) continue;
                if(color != 1 && visited[neighbor][c]) continue;
                visited[neighbor][c] = true;
                if(ans[neighbor] == -1 || ans[neighbor] > path + 1){
                    ans[neighbor] = path + 1;
                }
                queue.offer(new int[]{neighbor, path + 1, c});
            }

        }

        return ans;
    }
}

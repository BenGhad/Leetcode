class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);  
            adj.get(edge[1]).add(edge[0]);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int test = shortCycle(i, adj);
            ans = Math.min(ans, test);
            System.out.println("node " + i + ": " + test);
        }

        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    public int shortCycle(int root, List<List<Integer>> adj){
        int[] visited = new int[adj.size()];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        int level = -1;
        int shortest = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();

                if(visited[node] != -1){
                    int m1 = Integer.MAX_VALUE; // smallest
                    int m2 = Integer.MAX_VALUE; // 2nd smallest

                    for(int neighbor : adj.get(node)){
                        int lev = visited[neighbor];
                        if(lev == -1) continue;
                        if(lev < m1){
                            m2 = m1;
                            m1 = lev;
                        } else if(lev < m2){
                            m2 = lev;
                        }
                    }
                    if(m2 < Integer.MAX_VALUE){
                        shortest = Math.min(shortest, m1 + m2 + 2);
                    }
                }
                visited[node] = level;

                for(int neighbor : adj.get(node)){
                    if(neighbor == root && visited[node] == 1) continue;
                    if(visited[neighbor] == -1){
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return shortest;
    }
}

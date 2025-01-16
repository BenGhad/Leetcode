class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int ans = 0;
        boolean[] visited = new boolean[n];
        for(int i : restricted){
            visited[i] = true;
        }

        List<Integer>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            ans++;
            for(int neighbor : adj[node]){
                if(!visited[neighbor]){
                    queue.offer(neighbor);
                }
            }
        }

        return ans;
    }
}

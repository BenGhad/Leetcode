class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int[] conn : connections){
            int from = conn[0];
            int to = conn[1];
            adj[from].add(new int[]{to, 0}); // original direction
            adj[to].add(new int[]{from, 1}); // reverse direction
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ans = 0;
        while(!queue.isEmpty()){
            int city = queue.poll();
            visited[city] = true;
            for(int[] i : adj[city]){
                int next = i[0];
                if(!visited[next]){
                    queue.offer(next);
                    if(i[1] == 0) ans++;
                }
            }
        }

        return ans;
    }
}

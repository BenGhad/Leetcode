class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;
        
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[]{0, 0});


        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int node = current[0];
            int t = current[1];

            if(t > time[node]) continue;

            for(int[] neighbor : adj[node]){
                int dst = neighbor[0];
                int cost = neighbor[1];
                if(time[node] + cost < Math.min(time[dst], disappear[dst])){
                    time[dst] = time[node] + cost;
                    queue.offer(new int[]{dst, time[dst]});
                }
            }
        }


        
        for(int i = 0; i < n; i++){
            if(time[i] > disappear[i]) time[i] = -1;
        }
        return time;

    }
}

class Solution {
    static int[] dist;
    static List<Integer>[] adj;
    static int[] size; //subtree size
    static int[] parent;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1)
            return new int[] { 0 };
        if (n == 2)
            return new int[] { 1, 1 };

        adj = new ArrayList[n];
        dist = new int[n];
        size = new int[n];
        parent = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }
        parent[0] = -1; // root
        dfs1(0); // fills size[] and dist[0]
        ans[0] = dist[0];

        dfs2(0, n, ans); // re-root 

        return ans;
    }

    //  calculate subtre size & root distance size
    public void dfs1(int u){
        size[u] = 1;
        for(int v : adj[u]){
            if(v == parent[u]) continue;
            parent[v] = u;
            dfs1(v);
            size[u] += size[v];
            dist[u] += dist[v] + size[v];
        }
    }

    // convert root to everything else and go home 
    public void dfs2(int u, int n, int[] ans){
        for(int v : adj[u]){
            if(v == parent[u]) continue;
            ans[v] = ans[u] - size[v] + (n - size[v]);
            dfs2(v, n, ans);
        }
    }
}


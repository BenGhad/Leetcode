class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            dist[u][v] = Math.min(dist[u][v], c);
            dist[v][u] = Math.min(dist[v][u], c); 
        }


        for(int k = 0; k < n; k++){

            for(int i = 0; i < n; i++){

                for(int j = 0; j < n; j++){

                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int city = 0;
        int neighbors = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int c : dist[i]){
                if(c <= distanceThreshold) count++;
            }
            if(count <= neighbors){
                city = i;
                neighbors = count;
            }
        }

        return city;
    }
}

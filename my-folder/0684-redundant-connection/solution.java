class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int[] edge : edges){
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            if(!dsu.join(u, v)) return edge;
            
        }
        return new int[]{0, 0};
    }

    class DSU{
        int size;
        int[] parent;
        int[] rank;

        public DSU(int n){
            size = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int i){
            if(parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        public boolean join(int i, int j){
            int x = find(i);
            int y = find(j);

            if(x == y) return false;
            if(rank[x] < rank[y]){
                int tmp = x;
                x = y;
                y = tmp;
            }

            parent[y] = x;
            if(rank[x] == rank[y]){
                rank[x]++;
            }
            size--;
            return true;
        }
    }
}

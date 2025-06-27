class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    dsu.join(i, j);
                }
            }
        }


        return dsu.size;
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

        public void join(int i, int j){
            int x = find(i);
            int y = find(j);

            if(x == y) return;
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
        }
    }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<Integer>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> leafs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 2) {
            leafs = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (adj[node].size() == 1) {
                    leafs.add(node);
                } else {
                    queue.offer(node);
                }
            }

            for (int leaf : leafs) {
                for (int neighbor : adj[leaf]) {
                    adj[neighbor].remove(leaf);
                }
            }
        }


        List<Integer> ans = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }

        return ans;

    }
}

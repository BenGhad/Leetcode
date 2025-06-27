class Solution {
    public int minReorder(int n, int[][] edges) {
        List<Integer>[] forward = new ArrayList[n];
        List<Integer>[] backward = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            forward[i] = (new ArrayList<>());
            backward[i] = (new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            forward[u].add(v);
            backward[v].add(u);
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        int swp = 0;
        
        while(!queue.isEmpty()){
            int city = queue.poll();
            for(int c : forward[city]){
                if(!visited.contains(c)){
                    queue.add(c);
                    visited.add(c);
                    swp++;
                }
            }
            for(int c : backward[city]){
                if(!visited.contains(c)){
                    queue.add(c);
                    visited.add(c);
                }
            }

        }
        
        
        return swp;
    }
}

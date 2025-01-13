class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        //1 is blue, 2 is red

        for(int i = 0; i < graph.length; i++){
            if(colors[i] == 0) colors[i] = 1;

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i);

            while(!queue.isEmpty()){
                int n = queue.poll();
                int[] nodes = graph[n];
                for(int node : nodes){
                    if(colors[node] == 0){
                        colors[node] = 3 - colors[n];
                        queue.offer(node);
                    } else if(colors[node] == colors[n]) {
                        return false;
                    }
                }                
            }
        }

        return true;
    }
}

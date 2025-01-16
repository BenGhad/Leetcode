class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        
        //Create adj list
        List<List<int[]>> list = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : flights){
            list.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        
        for(int i = 0; i <= k; i++){
            int[] temp = Arrays.copyOf(price, n);
            int size = queue.size();
            for(int j = 0; j < size; j++){
                int city = queue.poll();
                for(int[] trip : list.get(city)){
                    int to = trip[0];
                    int cost = trip[1];
                    if(price[city] + cost < temp[to]){
                        temp[to] = price[city] + cost;
                        queue.offer(to);
                    }
                }
            }
            price = temp.clone();
        }

        

        return (price[dst] != Integer.MAX_VALUE) ? price[dst] : -1;
    }
}

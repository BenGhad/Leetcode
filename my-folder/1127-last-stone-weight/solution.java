class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) pq.offer(stone);
        
        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(x == y) continue;
            if(y < x){
                x ^= y;
                y ^= x;
                x ^= y;
            }

            pq.offer(y - x); // ABS but with aura
        }

        return pq.isEmpty() ? 0 : pq.poll();

    }
}

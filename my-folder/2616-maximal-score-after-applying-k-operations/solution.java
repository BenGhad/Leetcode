class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : nums){
            pq.add(i);
        }

        long score = 0;
        for(int i = 0; i < k; i++){
            int n = pq.poll();
            score += n;
            pq.add((n % 3 == 0) ? n / 3 : n / 3 + 1 );
        }
        return score;
    }
}

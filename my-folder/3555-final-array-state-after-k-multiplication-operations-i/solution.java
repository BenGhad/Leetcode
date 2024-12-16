class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]);
    }
    return Integer.compare(a[0], b[0]); 
});

        for(int i = 0; i < nums.length; i++){
            pq.add(new int[]{nums[i], i});
        }
        for(int i = 0; i < k; i++){
            int[] balls = pq.poll();
            balls[0] *= multiplier;
            pq.add(balls);
        }
        int[] ans = new int[nums.length];
        while(!pq.isEmpty()){
            int[] balls = pq.poll();
            ans[balls[1]] = balls[0];
        }
        return ans;
    }
}

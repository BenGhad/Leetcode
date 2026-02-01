class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue(2);
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            pq.offer(num);
        }

        return ans + pq.poll() + pq.poll();
    }
}

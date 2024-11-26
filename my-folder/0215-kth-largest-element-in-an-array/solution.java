class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums){
            p.offer(i);
        }

        for(int i = 1; i < k; i++){
            p.poll();
        }
        return p.poll();


    }
}

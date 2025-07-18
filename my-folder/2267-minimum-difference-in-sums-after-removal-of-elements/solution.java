class Solution {
    /*
    maintain pQueue of N left most
    pQueue of 2 * N right most,
    */
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] l = new long[n + 1];
        long[] r = new long[n + 1];

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        
        // leftMath:
        long lSum = 0;
        for(int i = 0; i < n; i++){
            lSum += nums[i];
            left.offer(nums[i]);
        }

        l[0] = lSum;
        
        for(int i = n; i < 2 * n; i++){
            int num = nums[i];
            if(num < left.peek()){
                lSum += num - left.poll();
                left.offer(num);
            }
            l[i - n + 1] = lSum;
        }

        // rightMath:
        long rSum = 0;
        for(int i = 3 * n - 1; i >= 2 * n; i--){
            rSum += nums[i];
            right.offer(nums[i]);
        }

        r[n] = rSum;
        for(int i = 2 * n - 1; i >= n; i--){
            int num = nums[i];
            if(num > right.peek()){
                rSum += num - right.poll();
                right.offer(num);                
            }
            r[i - n] = rSum;
        }

        long diff = Long.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            diff = Math.min(diff, l[i] - r[i]);
        }
        return diff;
    }
}

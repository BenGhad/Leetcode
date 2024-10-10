class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]){
                stack.push(i);
            }
        }

        int max = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                max = Math.max(max, i - stack.pop());
            }                
        }
        return max;

    }
}

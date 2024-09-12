class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int multi = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] *= multi;
            multi *= nums[i];
        }

/*
        int[] pre = new int[nums.length];
        int[] post  = new int[nums.length];
    
        pre[0] = 1;
        for(int i = 1; i < nums.length; i++){ //o(n): populate pre
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        post[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){ //o(n): populate post
            post[i] = post[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < nums.length; i++){ //o(n) ans
            ans[i] = pre[i] * post[i];
        }
         */

        
        return ans;
    }
}

class Solution {
    public int[] decrypt(int[] code, int k) {
       if(k == 0) return new int[code.length];
       int[] nums = new int[code.length];
       int sum = 0;
       if(k > 0){
            for(int i = 1; i <= k; i++){
                sum += code[i % code.length];
            }
            for(int i = 0; i < code.length; i++){
                nums[i] = sum;
                sum -= code[(i + 1) % code.length];
                sum += code[(1 + i + k) % code.length];
            }
       } else {
            k *= -1;
            for(int i = 0; i < k; i++){
                sum += code[i % code.length];
            }
            for(int i = 0; i < nums.length; i++){
                nums[(i + k) % code.length] = sum;
                sum += code[(i + k) % code.length];
                sum -= code[(i)];
            }

       }
 


       return nums;
    }
}

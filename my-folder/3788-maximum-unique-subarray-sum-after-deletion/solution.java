class Solution {
    public int maxSum(int[] nums) {
        int max = -101;
        boolean[] hashy = new boolean[101];
        int sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            if(num < 0 || hashy[num]) continue;
            hashy[num] = true;
            sum+=num;
        }
        return sum == 0 ? max : sum;
    }
}

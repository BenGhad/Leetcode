class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = n - 1;

        for(int num : nums){
            if(num % 2 == 0){
                ans[i++] = num;
            } else {
                ans[j--] = num;
            }
        }

        return ans;
    }
}

class Solution {
    public long minimumReplacement(int[] nums) {
        long result = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] <= nums[i + 1]) continue;
            // breakdown i such that < i + 1
            int[] math = breakDown(nums[i], nums[i + 1]);
            result += math[0];
            nums[i] = math[1];
        }

        return result;
    }

    // 0 - how many breaks. 1 - smallest num
    public int[] breakDown(int x, int y){
        int cuts = x / y;
        int min;

        if(x % y == 0){
            cuts--;
            min = y;
        } else {
            min = x / (cuts + 1);
        }
        return new int[]{cuts, min};
    }
}

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        //Arrays.sort(nums); 
        //Default sort is N log N, but because the range of numbers is small, we can use counting sort for  linear time. 

        countSort(nums);

        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k){
                return new int[0][0];
            }

            for (int j = 0; j < 3; j++) {
                ans[i / 3][j] = nums[i + j];
            }
        }

        return ans;
    }
    public void countSort(int[] nums){
        int r = 0;
        for(int i : nums){
            r = Math.max(r, i);
        }
        int[] bucket = new int[r + 1];
        for(int i : nums){
            bucket[i]++;
        }

        int ptr = 0;
        for(int num = 0; num < bucket.length; num++){
            for(int i = 0; i < bucket[num]; i++){
                nums[ptr++] = num;
            }
        }
    }
}

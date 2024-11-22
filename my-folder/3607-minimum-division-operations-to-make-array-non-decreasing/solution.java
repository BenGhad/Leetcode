class Solution {
    public int minOperations(int[] nums) {
        int div = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            while(nums[i] > nums[i + 1]){
                nums[i] = d(nums[i]);
                if(nums[i] == -1) return -1;
                div++;
            }
        }
        return div;
    }


    public int d(int num){
        if(num % 2 == 0 && num > 2) return 2;
        if(num % 3 == 0 && num > 3) return 3;
        
        for(int i = 5; i <= Math.sqrt(num); i += 6){
            if(num % i == 0) return i;
            if(num % (i + 2) == 0) return i + 2;
        }
        return -1;
    }
}

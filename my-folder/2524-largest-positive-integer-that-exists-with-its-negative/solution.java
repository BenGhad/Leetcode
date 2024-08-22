class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0){ return - 1;} //Edge case
        int posInd = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                posInd = i;
                break;
            }
        }

        for(int i = 0; i < posInd; i++){
            int x = nums[i] * -1;
            int low = i + 1; //log(N) binary search
            int high = nums.length - 1;
            boolean notFound = true;

            while(notFound){
                if(low > high){ break; }
                int mid = low + (high - low) / 2;

                if(nums[mid] < x){
                    low = mid + 1;
                } 
                
                if(nums[mid] > x){
                    high = mid - 1;
                }

                if(nums[mid] == x){
                    return nums[mid];
                }
            }

        }

        return -1;

    }
}

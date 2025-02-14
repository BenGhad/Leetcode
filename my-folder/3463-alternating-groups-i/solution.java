class Solution {
    public int numberOfAlternatingGroups(int[] nums) {
        int n = nums.length;
        int first = 0;
        int second = 1;
        int third = 2;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[first] == nums[third] && nums[first] != nums[second]) count++;
            first = second;
            second = third;
            third = (third + 1) % n;
        }
        return count;
    }
}

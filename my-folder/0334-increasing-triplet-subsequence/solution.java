class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i : nums){
            if(i < first){
                first = i;
            }
            if(i < second && i > first){
                second = i;
            }
            if(i > second && i > first){
                return true;
            }
        }
        return false;
    }
}

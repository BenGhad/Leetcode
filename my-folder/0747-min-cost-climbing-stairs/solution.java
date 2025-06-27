class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;
    
        for(int i = 0; i < cost.length; i++){
            int c = Math.min(one, two) + cost[i];    
            two = one;
            one = c;
        }
        
        return Math.min(two, one);
        
        
    }
}

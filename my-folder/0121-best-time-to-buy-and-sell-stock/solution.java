class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int val : prices){
            if(min > val){
                min = val;
            } else {
                profit = Math.max(profit, val - min);
            }
        }
        return profit;
    }
}

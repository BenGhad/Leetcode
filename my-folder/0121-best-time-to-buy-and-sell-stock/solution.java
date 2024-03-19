class Solution {
    public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
         return 0;
      }
    int profit = 0, minPrice = prices[0];
    for(int i : prices){
        if(minPrice > i){
            minPrice = i;
        } else if(i - minPrice > profit) {
            profit = i - minPrice;
        }
    }
    
    return profit;    
    }
}

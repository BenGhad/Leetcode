class Solution {
    public int minCostToMoveChips(int[] position) {
        int odds = 0;
        int evens = 0;
        for(int pos : position){
            if(pos % 2 == 0){
                evens++;
            } else {
                odds++;
            }
        }
        return Math.min(evens, odds);
    }
}

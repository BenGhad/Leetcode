class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int min = -1;
        while(l <= r){
            int k = l + (r - l) / 2;
            int koko = canEat(piles, h, k);
            if(koko == 0){
                r = k - 1;
                min = k;    
            }
            if(koko == 1){
                l = k + 1;
            }
        }
        return min;
    }
    public int canEat(int[] piles, int h, int k){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil((double)pile / k);
        }
        return hours > h ? 1 : 0;
    }
}

class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int c = candyType.length;

        int ans = 0;
        int count = 1;
        
        for(int i = 1; i < candyType.length; i++){
            if(candyType[i - 1] != candyType[i]){
                count++;
            }
        }
        
        
        return Math.min(c / 2, count);
        
    }
}

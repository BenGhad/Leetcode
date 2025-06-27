class Solution {
    public int hammingWeight(int n) {
        /* idea:
        if odd: weight++
        divide by 2
        */
        int weight = 0;
        while(n > 0){
            if(n % 2 == 1) weight++;
            n /= 2;
        }
        
        return weight;
    }
}

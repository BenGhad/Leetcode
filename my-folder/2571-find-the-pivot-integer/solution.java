import java.lang.Math;
class Solution {
    public int pivotInteger(int n) {
        
        if(n == 1){ return n;}

        for(int i = 1; i < n; i++){
            int s1 = (i) * (i+1) / 2; 
            int s2 = (n - i + 1) * (i+n)/2;
            if (s1 == s2){
                return i;
            }
        }
        return -1; 
    }
}

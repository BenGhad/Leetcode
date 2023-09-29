class Solution {
    public boolean isUgly(int N) {
        if(N < 1){return false;}
  
  
      //  Solution 1: 
        while(N % 2 == 0){
            N = N / 2;
        } 
        while(N % 3 == 0){
            N = N / 3;
        } 
        while(N % 5 == 0){
            N = N / 5;
        } 

        


    /** Solution 2: 1 ms, 39.39 mb    
    for(int i = 2; i <= 5; i = (int)((double)i * 1.7)){
        while(N % i == 0){ N = N / i; }
    }
**/
    return N == 1;

    }
}

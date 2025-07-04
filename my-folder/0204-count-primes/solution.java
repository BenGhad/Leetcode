class Solution {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        
       for (int i = 0; i < n; i++) {
            sieve[i] = true;
        }

        for(int p = 2; p * p < n; p++){
            if(sieve[p]){
                for(int i = p * p; i < n; i += p){
                    sieve[i] = false;
                }
            }
        }

        int count = 0;
        for(int p = 2; p < n; p++){
            if(sieve[p]) count++;
        }
        return count;
    }
}

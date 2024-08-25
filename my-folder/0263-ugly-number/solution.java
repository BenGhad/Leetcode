class Solution {
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        while(n % 2 == 0){
            n = n /2;
        }
        while(n % 3 == 0){
            n = n / 3;
        }
        while(n % 5 == 0){
            n = n / 5;
        }

        if(isPrime(n)){
            return false;
        }

        for(int i = 7; i <= n / 2; i = i + 2){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    public boolean isPrime(int n){
        if(n == 1){ return false; }
        for(int i = 5; i <= Math.sqrt(n); i = i + 6){
            if(n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
}

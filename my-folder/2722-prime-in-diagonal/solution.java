class Solution {
    public int diagonalPrime(int[][] nums) {
        int prime = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(isPrime(nums[i][i])){
                prime = Math.max(prime, nums[i][i]);
            } 
            if(isPrime(nums[i][n - i - 1])){
                prime = Math.max(prime, nums[i][n - i -1]);
            }
        }
        return prime;
    }

    public boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        if(n == 2 || n == 3){
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0){
            return false;
        }
        for(int i = 5; i * i <= n; i+= 6){
            if(n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }

        return true;
    }
}

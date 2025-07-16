class Solution {
    public int maximumLength(int[] nums) {
        int odds = 0;
        int evens = 0;
        int par = 0;
        
        int parity = -1;
        
        for(int num : nums){
            if(num % 2 == 0){
                evens++;
            } else {
                odds++;
            }

            if(num % 2 != parity){
                parity = num % 2;
                par++;
            }
        }

        return Math.max(par, Math.max(odds, evens));
    }
}

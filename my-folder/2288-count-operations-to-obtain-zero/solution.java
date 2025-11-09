class Solution {
    public int countOperations(int num1, int num2) {
        int op = 0;
        while(Math.min(num1, num2) != 0){
            op++;
            if(num1 > num2){
                num1 ^= num2;
                num2 ^= num1;
                num1 ^= num2;
            }
            num2 -= num1;
        }

        return op;
        
    }
}

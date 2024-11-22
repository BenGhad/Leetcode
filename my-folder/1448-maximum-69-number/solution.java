class Solution {
    public int maximum69Number (int num) {
        int max = num;
        int[] digits = new int[5];
        for(int i = 0; i < digits.length; i++){
            digits[i] = num % 10;
            num /= 10; 
        }
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 6){
                return max += 3 * (int)Math.pow(10, i);
            }
        }
        return max;

    }
}

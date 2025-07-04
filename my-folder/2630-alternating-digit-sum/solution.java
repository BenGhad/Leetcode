class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int sign = 1;

        Stack<Integer> num = new Stack<>();
        while(n > 0){
            num.push(n % 10);
            n /= 10;
        }
        
        while(!num.isEmpty()){
            sum += sign * num.pop();
            sign *= -1;
        }
        return sum;
    }
}

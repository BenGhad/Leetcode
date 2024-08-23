class Solution {
    public String fractionAddition(String expression) {
        String exp = "";
        if(expression.charAt(0) == '-'){
            exp = "0/1" + expression;
        } else {
            exp = expression;
        }
        String[] fractions = exp.split("(?=[+-])");
        int bigNum = 0;
        int bigDenom = 1; //Common Denominator
        for(String fraction : fractions){
            String[] splitty = fraction.split("/");
            int num = Integer.parseInt(splitty[0]);
            int denom = Integer.parseInt(splitty[1]);
            bigNum = bigNum * denom + num * bigDenom;
            bigDenom *= denom;
        }


        int gcd = gcd(Math.abs(bigNum), Math.abs(bigDenom));
        bigNum /= gcd;
        bigDenom /= gcd;
        
        return bigNum + "/" + bigDenom;

    }
    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

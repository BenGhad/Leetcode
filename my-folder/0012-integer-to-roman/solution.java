class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int d1 = num / 1000;
        num -= d1 * 1000;
        
        for(int i = 0; i < d1; i++){
            sb.append("M");
        }

        int d2 = num / 100;
        num -= d2 * 100;
        
        digToRoman(sb, 'C', 'D', 'M', d2);
        
        int tenth = num / 10;
        int unit = num % 10;

        //Tenth
        digToRoman(sb, 'X', 'L', 'C', tenth);

        //Unit digit
        digToRoman(sb, 'I', 'V', 'X', unit);

        return sb.toString();
    }

    public void digToRoman(StringBuilder sb, char one, char five, char ten, int digit){
        if(digit == 4){
            sb.append(one);
            sb.append(five);
        } else if(digit == 9){
            sb.append(one);
            sb.append(ten);
        } else if(digit < 5){
            for(int i = 0; i < digit; i++){
                sb.append(one);
            }
        } else {
            sb.append(five);
            for(int i = 5; i < digit; i++){
                sb.append(one);
            }
        }
    }
}

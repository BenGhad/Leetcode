class Solution {
    // 
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        if(num1.length() > num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int diff = num2.length() - num1.length();
        
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            
            int dig = carry + (num1.charAt(i) - '0') + (num2.charAt(i + diff) - '0');
            sb.append((char)(dig % 10 + '0'));
            carry = dig / 10;
        }
        
        for(int i = diff - 1; i >= 0; i--){
            int dig = carry +  (num2.charAt(i) - '0');
            sb.append((char)(dig % 10 + '0'));
            carry = dig / 10;
        }
        if (carry > 0) {
            sb.append((char) ('0' + carry));
        }
        
        return sb.reverse().toString();
    }
}

class Solution {
    public String largestPalindromic(String num) {
        int[] digits = new int[10];
        StringBuilder ans = new StringBuilder();
        //Strip the String
        for(int i = 0; i < num.length(); i++){
            int n = num.charAt(i) - '0';
            digits[n]++;
        }
        //Assemble palindrome
        boolean mid = false;
        int middle = -1;
        for(int i = 0; i < 10; i++){
            int digit = digits[i];
            for(int j = 0; j < digit / 2; j++){
                ans.insert(0, i);
                ans.append(i);
            }
            if(digit % 2 != 0){
                mid = true;
                middle = i;
            }
        }
        int len = ans.length(); 
        if(mid){ //insert middle
            ans.insert(len / 2, middle);
        }
        int start = 0;
        for(int i = 0; i < ans.length(); i++){ //leadingZeroes
            int digit = ans.charAt(i) - '0';
            if(digit != 0){
                start = i;
                break;
            }
        }
        if(ans.charAt(start) == '0'){return "0";}
        if(start != 0){
        return ans.substring(start, len - start  + 1);
        }
        return ans.toString();
        
        
    }
}

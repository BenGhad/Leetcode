class Solution {
    public int romanToInt(String s) {

    int output = 0;
        for(int i = s.length() - 1; i > -1; i--){
            char tmp = s.charAt(i);
            char post = (i < s.length() - 1) ? s.charAt(i+1) : ' ';            
            if(tmp == 'I'){
                output = post == 'V' || post == 'X' ? output - 1 : output + 1;
            } else if(tmp == 'V'){
                output += 5;   
            } else if(tmp == 'X'){
                 output = post == 'L' || post == 'C' ? output - 10 : output + 10;
            } else if(tmp == 'L'){
                output +=50;
            } else if(tmp == 'C'){
                 output = post == 'D' || post == 'M' ? output - 100 : output + 100;
            } else if(tmp == 'D'){
                output +=500;
            } else if(tmp == 'M'){
                output +=1000;
            }
        }
        return output;
    }
}

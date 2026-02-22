class Solution {
    public String maximumXor(String s, String t) {
        int ones = 0;
        int zero = 0;
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '1'){
                ones++;
            } else{
                zero++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                if(zero > 0){
                    zero--;
                    sb.append('1');
                } else {
                    ones--;
                    sb.append('0');
                }
            } else {
                if(ones > 0){
                    ones--;
                    sb.append('1');
                } else {
                    zero--;
                    sb.append('0');
                }
            }
        }

        return sb.toString();
    }
}

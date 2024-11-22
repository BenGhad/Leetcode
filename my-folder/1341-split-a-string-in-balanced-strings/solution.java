class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int l = 0;
        int r = 0;
    
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L'){
                l++;
            } else {
                r++;
            }
            if(l != 0 && l == r){
                count++;
                l = 0;
                r = 0;
            }
        }
        return count;
    }
}

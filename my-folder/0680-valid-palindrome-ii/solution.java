class Solution {
    public boolean validPalindrome(String s) {
    int f = 0;
    int l = s.length() - 1;
    boolean del = false;
    while(f < l){     
        if(s.charAt(f) != s.charAt(l)){

            if(isPal(s, f + 1, l)){
                return true;
            } else if(isPal(s, f, l - 1)){
                return true;
            } else {
                return false;
            }
        } 
        f++;
        l--;
    }
    
    return true;    
    }
    public boolean isPal(String s, int f, int l){
        int lef = f;
        int rig = l;
        while(lef < rig){
            if(s.charAt(lef) != s.charAt(rig)){
                return false;
            }
            lef++;
            rig--;
        }  
        return true;
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
    if(s.length() == 0){return true;}
    int subLen = 0;
    char crnt = s.charAt(subLen);
    
    for(int i = 0; i < t.length(); i++){
        char tmp = t.charAt(i);
        if(tmp == crnt){
            if(subLen == s.length() - 1){
                return true;
            }
            subLen++;
            crnt = s.charAt(subLen);
            

        }
    }

    return false;   
    }
}
